# restful-web-services
Run vscode with remote container on jvm 11 with spring boot.

## First
1.- Install vscode and remote extensionpack from https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.vscode-remote-extensionpack

2.- Install extension vscjava.vscode-java-pack and pivotal.vscode-boot-dev-pack

3.- You need download docker images from jvm 11 on dockerhub (link https://hub.docker.com/_/oracle-jdk)

$ docker pull store/oracle/jdk:11

4.- Clone the source and run it from vscode 

https://code.visualstudio.com/docs/java/java-tutorial


## Dockerfile

Use image store/oracle/jdk:11, for adds,  

Install tar and gzip

Create vscode user 

Install maven and create a symbolic link


