#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <netdb.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <unistd.h>
#include <arpa/inet.h>
bool Serve(int client_socket){
    while(true){
        int length;
        char *msg;
        if(read(client_socket,&length,sizeof(length))==0){
            return true;
        }
        msg=new char[length];
        read(client_socket,msg,length);
        printf("%s/0",msg);
        if(!strcmp(msg,"quit")){
            delete[] msg,msg=NULL;
            return false;
        }else{
            char hello[]="hello,nihao?\n";
            write(client_socket,hello,strlen(hello));
            delete[] msg,msg=NULL;
        }
    }
}
int main(int argc,char * const argv[]){
    int sockfd,newfd;
    struct sockaddr_in server_addr,client_addr;
    char hello[]="Hello nihao";
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
        Serve(newfd);
        close(newfd);
    }
    close(sockfd);
    return 0;
}
