# CS3200 Starter App
Hi class! As some of you have noticed, the hardest thing we might do all semester is actually get these applications setup. While it is important to know how to set one up, from now on you can just use this one as a starting point. This starter app gives you the following things right out of the box:

1. A phone app
2. A watch app
3. An API module
4. Dependencies for Firebase, DataBinding, and LifeCycle
5. Any code we write in class that is generally reusable.

## Setup
To get starting doing development you need follow these steps (Your project tree should be in Android view):

1. Download the starter code.
1. Open Up `Gradle Scripts/settings.gradle` and change the value of `rootProject.name` to be whatever your project is called, for example `rootProject.name = "Assignment2"`.
1. Right Click on the `Watch Starter` module, select `Refactor > Rename` and rename to your desired name.
1. Repeat previous step for the other modules.
1. Open up the `API` module's `manifests/AndroidManifest.xml` file.
    -  In the package name attribute, right click on the `example` portion of `com.example.api` and select `Refactor > Rename`.
    - Click the `Rename Package` button.
    - In the dialog change "example" to be the following `<yourname><appname><assignment number>`. For example, if I were building a calculator for assignment 2 I would put `josephdittoncalculatorassignment2`.
    - Click `Refactor`
    - The final package name should read (using the previous example) `com.josephdittoncalculatorassignment2.api`
1. Repeat step 5 for the other modules
1. Open the `build.gradle` file for the module for your phone app
    - Change the value of `applicationId` to be your new package name.
1. Repeat previous step for the watch app.
1. Create a project in firebase
1. Create 2 apps in Firebase, one for the Phone App and another for the Watch App
1. Download the google-services.json files for each app and put the in the proper place.
1. Enable the Real Time Database feature of firebase
1. Run each app and make sure they launch. (If you didn't do the previous step correctly you will get an error)
1. In your firebase console verify that you see the values `phoneAppVerified: true` and `watchAppVerified: true`
1. Delete the hidden `.git` folder in the project root then you can push set up the project to push up to your own git repo.

Thats it, all of the dependencies are already added and linked for you!