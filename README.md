# music-quote

![](https://github.com/littlewing/music-quote/workflows/CI/badge.svg)

## Setup 

### Pre requisites

Gradle
Kotlin

### Gcloud & K8S setup

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
docker login docker.pkg.github.com
gcloud auth print-access-token | docker login -u oauth2accesstoken --password-stdin https://gcr.io 
docker pull docker.pkg.github.com/littlewing/music-quote/music-quote-jvm:upgrade_quarkus

docker tag docker.pkg.github.com/littlewing/music-quote/music-quote-jvm:upgrade_quarkus gcr.io/music-quote/music-quote-jvm:v0

gcloud auth print-access-token | docker login -u oauth2accesstoken --password-stdin https://gcr.io 
docker push gcr.io/music-quote/music-quote-jvm:v0
kubectl create deployment music-quote --image=gcr.io/music-quote/music-quote-jvm:v0