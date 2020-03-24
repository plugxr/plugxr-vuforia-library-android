# PlugXR Vuforia Library Android
[![](https://jitpack.io/v/plugxr/plugxr-vuforia-library-android.svg)](https://jitpack.io/#plugxr/plugxr-vuforia-library-android)


1. Create project or Open existing android project in android studio
	Make sure your project has following versions
	
	*minSdkVersion: 22*
	
	*targetSdkVersion: >=28*
	
	*gradle version: 3.4.2*

2. Clone plugxr-vuforia-library-android library

	`git clone https://github.com/plugxr/plugxr-vuforia-library-android.git`

3. Click on `File -> New -> Import Module`. Then select `plugxr-vuforia-library-android` as module which is cloned in step 2.

4. Open your app `build.gradle` and place below code in dependencies section.

	```java
	implementation project(':plugxr-vuforia-library-android')
	```

5. Add below lines in project `build.gradle` module under `allprojects` module
	```java
	flatDir {
            dirs project(':plugxr-vuforia-library-android').file('libs')
        }
    ```

6. Now Sync your project with gradle files

7. Add Permissions to your app `AndroidManifest.xml` file.
	```xml
	<uses-permission android:name="android.permission.INTERNET"/>
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION">
	<uses-permission android:name="android.permission.CAMERA"/>
	<uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS"/>
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
	<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
	<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
	```

8. Now open your `activity_main.xml` file and create button
	```xml
	<Button
		android:id="@+id/arscene"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="AR SCENE"
		android:layout_gravity="center"
	/>
	```

9. Initialize button in your `MainActivity.java` file and give click event to button And call PlugXR AR Scene
	```java
	// Initialize Plugxr Ar Scene here
	Plugxr plugxrARScene = new Plugxr(getApplicationContext());
	// Set Vuforia license keys here
	plugxrARScene.setVuforiaKeys(licenceKeyToUnity,accessKeyToUnity,secretKeyToUnity);
	// Start Plugxr AR when click on the button
	Button button = (Button)findViewById(R.id.startAr);
	button.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			plugxrARScene.start();
		}
	});
	```
10. Run Application


> *NOTE*: If you are facing any issues, Please raise a issue [here](https://github.com/plugxr/plugxr-vuforia-library-android/issues/new). We will resolve issues as soon as possible
