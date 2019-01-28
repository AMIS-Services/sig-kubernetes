#!/bin/bash
echo "Begin installing docker"
sudo apt-get remove docker docker-engine docker.io
sudo apt-get install apt-transport-https
sudo apt-get install ca-certificates
sudo apt-get install curl
sudo apt-get install software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
    $(lsb_release -cs) \
    stable"

sudo apt-get update -qq
#sudo apt-get install -yqq docker-ce #By default, it installs the latest version of docker
sudo apt-get install -yqq docker-ce=18.06.1~ce~3-0~ubuntu 
usermod -aG docker vagrant
sudo docker run hello-world
echo "End installing docker"