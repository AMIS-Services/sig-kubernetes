#!/bin/bash
echo "Begin installing kubectl"
apt-get update -qq && apt-get install -qqy apt-transport-https
curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | apt-key add -
echo "deb http://apt.kubernetes.io/ kubernetes-xenial main" > /etc/apt/sources.list.d/kubectl.list
apt-get update -qq
apt-get install -qqy kubectl
echo "End installing kubectl"