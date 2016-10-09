# FirstDive

An Android library that helps you easily run tasks at the very first launch of your Application. (i.e., database seeding)


## How to use

Add this line to your gradle dependencies

`compile 'com.jezercrespo.first-dive:1.1'`


### Usage
```java
   FirstDive.getInstance(this).doOnFirstLaunch(new OnFirstLaunch() {
            @Override
            public void doOnFirstLaunch() {
                // TODO your task to perform
            }
        });
```


```
Copyright 2015 Jezer Crespo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.```
