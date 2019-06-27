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

Because this library is based on data binding library remember enabling it in your project.
app _build.gradle_
```Gradle
android {
    ...
    dataBinding {
        enabled true
    }   
}
dependencies {
    implementation 'software.rsquared:data-bound-list-adapter:1.0.0'
}
```
[![](https://jitpack.io/v/software.rsquared/data-bound-list-adapter.svg)](https://jitpack.io/#software.rsquared/data-bound-list-adapter)

## What's inside?
_todo description_
