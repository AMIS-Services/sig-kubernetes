#!/bin/bash
echo "Begin setting up and starting kubernetes (k8s)"
sudo apt-get update -qq
sudo apt-get install ebtables
sudo apt-get install socat

sudo minikube start --vm-driver none

echo "Get Information About the Nodes in a Cluster"
sudo cp /etc/kubernetes/admin.conf $HOME
sudo chown $(id -u):$(id -g) $HOME/admin.conf
export KUBECONFIG=$HOME/admin.conf
kubectl get nodes
echo "Display cluster info"
kubectl cluster-info

#sudo minikube dashboard –url

kubectl proxy --address='0.0.0.0' --port=8001
echo "End setting up and starting kubernetes (k8s)"