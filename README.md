# DataBoundListAdapter
_todo description_

## Gradle Dependency (jitpack.io)

project level _build.gradle_
```Gradle
allprojects {
    repositories {
        ...
	maven { url 'https://jitpack.io' }
    }
}
```

app _build.gradle_
```Gradle
dependencies {
    implementation 'software.rsquared:data-bound-list-adapter:1.0.0'
}
```
[![](https://jitpack.io/v/software.rsquared/data-bound-list-adapter.svg)](https://jitpack.io/#software.rsquared/data-bound-list-adapter)

Becasue this library is based on data binding library remember enabling it in your project
```Gradle
android {
    ...
    dataBinding {
        enabled true
    }   
}
```

## What's inside?
_todo description_
