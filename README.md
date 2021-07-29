# OpenCV4Android

OpenCV is an open-source computer vision and machine learning library written in C++. It has support for languages like Python, MATLAB, Java and can be used with Windows, Linux, MacOS and Android.

You can find more at [OpenCV offcial website](https://opencv.org/)

The aim of this project is to ascertain the viability of OpenCV as a platform for Java-literate novice mobile application developers for developing computer vision-based software.

To clone/build this project yourself you require to import OpenCV into your own project using Android Studio. 

Here are below the steps to do so.

1. [Download OpenCV](https://opencv.org/releases/) from offcial website (select version 4.5.1 Android)
2. Clone this project using Android Studio
3. Open the project and comment out like this `//implementation project(path: ':opencv')` in app level build.gradle file![image](https://user-images.githubusercontent.com/46922724/121899856-b555a780-cd1c-11eb-9157-7b4ec150c1d0.png)
4. Go to `File/New/Import Module`, you should see a window prompting to select a file
5. Select the unzipped file inside it `OpenCV-android-sdk\sdk`
6. Name the module `opencv` and then press finish
7. When complete remove the comments from the build.gradle `implementation project(path: ':opencv')`
8. Build and run as you like 😁
