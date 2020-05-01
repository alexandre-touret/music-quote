# music-quote

![](https://github.com/littlewing/music-quote/workflows/CI/badge.svg)![](https://github.com/littlewing/music-quote/workflows/CD/badge.svg)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=touretinfo:littlewing_music-quote&metric=alert_status)](https://sonarcloud.io/dashboard?id=littlewing_music-quote)
## Setup 

### Pre requisites

Gradle
Kotlin

### Gcloud & K8S setup
https://github.com/GoogleCloudPlatform/github-actions 
This project could be deployed into Google Cloud K8S engine

Install google cloud sdk


 4364  2020-04-30 11:31  echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list
 4365  2020-04-30 11:31  curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -
 4366  2020-04-30 11:33  sudo apt-get update && sudo apt-get install google-cloud-sdk
 4367  2020-04-30 11:33  sudo apt-get update
 4368  2020-04-30 11:33  sudo apt-get dist-upgrade
 4369  2020-04-30 11:35  sudo apt-get update && sudo apt-get install google-cloud-sdk


curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -

sudo apt install kubectl


apply this documentation : https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes/


## Deployment

through github actions

## Locally

create secret 

kubectl create secret docker-registry github-registry --docker-server=docker.pkg.github.com --docker-username=USER--docker-password=PASSWORD --docker-email=EMAIL


kubectl apply -f ./k8s/db-configmap.yml
kubectl apply -f ./k8s/db-statefulset.yml
kubectl apply -f ./k8s/db-service.yml
kubectl apply -f ./k8s/api-deployment.yml
