#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <netdb.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/utsname.h>
#include <sstream>

using namespace std;
void createContent(char* content){
    strcpy(content,"Content-Length:");
    struct utsname u;
    if(uname(&u)==-1){
        return ;
    }
    char uname[1024];
    strcpy(uname,"Sysname:");
    strcat(uname,u.sysname);
    strcat(uname,"\r\n");
    strcat(uname,"<br />Machine:");
    strcat(uname,u.machine);
    strcat(uname,"\r\n");
    int length=strlen(uname);
    stringstream ss;
    ss<<length;
    string str;
    ss>>str;
    strcat(content,str.data());
    strcat(content,"\r\n\r\n");
    strcat(content,uname);
    strcat(content,"\r\n");

    return;
}
bool serve(int client_socket){
    while(true){
        int length=1024;
        char *msg;
        msg=new char[length];
        if(read(client_socket,msg,sizeof(char)*length)==-1){
            return false;
        }
        printf("%s",msg);
        if(!strcmp(msg,"quit\n")){
            delete[] msg,msg=NULL;
            return false;
        }else{
            delete[] msg,msg=NULL;
            char head[1024];
            strcpy(head,"HTTP/1.1 200 OK\r\nContent-Type:text/html;charset=utf8\r\n");
//            strcat(head,"Connection:keep-alive\r\nKeep-Alive:timeout=2\r\n");
            char content[1024];
            char response[1024];
            createContent(content);
            strcpy(response,head);
            strcat(response,content);
            if(write(client_socket,response,strlen(response))==-1){
                return false;
            }
        }
    }
}
int main(int argc,char * const argv[]){
    int sockfd,newfd;
    struct sockaddr_in server_addr,client_addr;
    if((sockfd=socket(AF_INET,SOCK_STREAM,0))==-1){
        fprintf(stderr,"socket error:%s\n\a",strerror(errno));
        exit(1);
    }
    bzero(&server_addr,sizeof(struct sockaddr_in));
    server_addr.sin_family=AF_INET;
    server_addr.sin_addr.s_addr=htonl(INADDR_ANY);
    server_addr.sin_port=htons(8787);
    if(bind(sockfd,(struct sockaddr *)(&server_addr),sizeof(server_addr))==-1){
        fprintf(stderr,"bind error:%s\n\a",strerror(errno));
        exit(1);
    }
    if(listen(sockfd,1)==-1){
        fprintf(stderr,"listen error:%s\n\a",strerror(errno));
        exit(1);
    }
    while(true){
        socklen_t sin_size;
        if((newfd=accept(sockfd,(struct sockaddr *)(&client_addr),&sin_size))==-1){
            fprintf(stderr,"accept error:%s\n\a",strerror(errno));
        }
        serve(newfd);
        close(newfd);
    }
    close(sockfd);
    return 0;
}
