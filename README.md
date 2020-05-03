# music-quote

![](https://github.com/littlewing/music-quote/workflows/CI/badge.svg)![](https://github.com/littlewing/music-quote/workflows/CD/badge.svg)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=littlewing_music-quote&metric=alert_status)](https://sonarcloud.io/dashboard?id=littlewing_music-quote)
## Setup 

This project could be deployed using K8S.
I configured two github actions to build and deploy from the master branch a docker image to Google Cloud Kubenetes engine.

### Pre requisites

Use these tools
* Gradle
* Kotlin
* JDK 8 ( 11 soon )

### Gcloud & K8S setup

#### Gcloud 

I installed Gcloud sdk by running the following commands

```jshelllanguage
echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list
curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -
sudo apt-get update && sudo apt-get install google-cloud-sdk
sudo apt-get update
sudo apt-get dist-upgrade
sudo apt-get update && sudo apt-get install google-cloud-sdk

```
Then you could run this command to login 

```jshelllanguage
gcloud auth login
```

To get all the informations to configure gcloud (service account, iam, k8s cluster,...), you can follow the following resources:

* [Google Cloud Github action](https://github.com/GoogleCloudPlatform/github-actions)
* [Cloud springboot kubenetes codelab](https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes/)


#### K8S
You could install Kubectl by running the following commands:

```jshelllanguage
echo "deb https://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee -a /etc/apt/sources.list.d/kubernetes.list
sudo apt-get update
sudo apt-get install -y kubectl
```

You could get the kubectl credential in your local configuration by running this command:

```jshelllanguage
gcloud container clusters get-credentials cluster-name
```



## Deployment

### Before deploying

You have to create a K8S secret by running this command

```jshelllanguage
kubectl create secret docker-registry github-registry --docker-server=docker.pkg.github.com --docker-username=USER--docker-password=PASSWORD --docker-email=EMAIL
```

### Using Github actions
By running the [CD Github workflow](./.github/workflows/gke.yml), you can :
* Build a docker image and deploy it in github docker repository
* Deploy on Google Cloud Kubernetes Engine

##### Secrets variables needed

In settings/secrets, you have to configure the following secrets:

| Secret key  | How to get it ?          | 
| :--------------- |:---------------:|
| ``GKE_CLUSTER`` |   `` gcloud container clusters list``      |
| ``GKE_PROJECT``  | ``gcloud container clusters list``           | 
| ``GKE_SA_EMAIL``  | ``gcloud container clusters list``    |
| ``GKE_ZONE `` | ``gcloud container clusters list``           |
| ``SONAR_TOKEN``  | Go to sonarcloud          | 

## Locally

create secret 


kubectl apply -f ./k8s/db-configmap.yml
kubectl apply -f ./k8s/db-statefulset.yml
kubectl apply -f ./k8s/db-service.yml
kubectl apply -f ./k8s/api-deployment.yml
