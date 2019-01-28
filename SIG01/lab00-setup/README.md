# Setup environment for Labs
This project contains labs to setup and prepare your local environment for use in the other labs.

## Getting Started

Before you start you need to decide what setup you prefer as there are two versions:

* Native on Windows 10 (requires Hyper-V)
  * Uses Chocolatey (package manager for windows) the labs installs Docker-For-Windows, Kubernetes CLI (kubectl) and Kubernetes Container running on minikube.
* Using a vagrant VM running Ubuntu 16.04 (requires Virtual Box)
  * One-stop-shop VM with docker, kubectl, minikube

## Prerequisites

So for both options you need a recent laptop with a minimum of 8GB of RAM.

For the second option you need to have VirtualBox and Vagrant installed: 

* VirtualBox 5.2.24: https://www.virtualbox.org/wiki/Download_Old_Builds_5_2
* Vagrant 2.2.3: https://www.vagrantup.com/downloads.html

## Setup environment

1. Lab 1a: [Setup natively on Windows 10](setupNativeWIN10.md) ([pdf](setupNativeWIN10.pdf))
2. Lab 1b: [Setup using vagrant + Ubuntu](InstallationMinikubeViaVagrantWorkShop.docx)