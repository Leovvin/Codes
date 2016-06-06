#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <sys/socket.h>
#include <sys/un.h>
#include <unistd.h>
bool Serve(int client_socket){
    while(true){
        int length;
        char *msg;
        if(read(client_socket,&length,sizeof(length))==0){
            return true;
        }
        msg=new char[length];
        read(client_socket,msg,length);
        std::cout<<msg<<std::endl;
        if(!strcmp(msg,"quit")){
            delete[] msg,msg=NULL;
            return false;
        }else{
            delete[] msg,msg=NULL;
        }
    }
}
int main(int argc,char * const argv[]){
    const char * const socket_name=argv[1];
    int socket_fd;
    struct sockaddr_un name;
    bool serving=true;
    socket_fd=socket(PF_LOCAL,SOCK_STREAM,0);
    name.sun_family=AF_LOCAL;
    strcpy(name.sun_path,socket_name);
    bind(socket_fd,(struct sockaddr *)&name,SUN_LEN(&name));
    listen(socket_fd,5);
    while(serving){
        struct sockaddr_un client_name;
        socklen_t client_name_len;
        int client_socket_fd=accept(socket_fd,(struct sockaddr *)&client_name,&client_name_len);
        serving=Serve(client_socket_fd);
        close(client_socket_fd);
    }
    close(socket_fd);
    unlink(socket_name);
    return 0;
}
