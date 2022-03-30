# Cryptohopper Android SDK -> Kotlin

[![JitPack](https://jitpack.io/v/cryptohopper/cryptohopper-android-sdk.svg)](https://jitpack.io/#cryptohopper/cryptohopper-android-sdk)


Add following to your root build.gradle

```
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

add a dependency to your app's build.grade as follows

```
dependencies {
            implementation 'com.github.cryptohopper:cryptohopper-android-sdk:1.0.2'
    }
```

# Integrate the SDK into your app

Initialize Cryptohopper SDK in your main activity .

This is required before you are making any request with the sdk

```
CryptoHopperConfig.configure(getApplicationContext(),"YOUR_CLIENT_ID_HERE",HopperAPIEnvironment.PRODUCTION)
```

Replace "YOUR_CLIENT_ID_HERE" string with client id that is given to you by Cryptohopper . If you don't have one you can request it from here : https://www.cryptohopper.com/api-documentation/introduction

# Contexts

There are 7 differen contexts in the SDK that you can request data from which are :

```
CryptohopperAuth
```

```
CryptohopperHopper
```

```
CryptohopperMarketplace
```

```
CryptohopperUser
```

```
CryptohopperTemplate
```

```
CryptohopperExchange
```

```
CryptohopperStrategy
```

Each of the contexts above has some static methods that you can see from inside.

# Example Usage

Example login Request :

```
CryptohopperAuth.login("test","test",callback = { s: String?, hopperError: HopperError? ->
    if(s != null){
        //After this method succeed you can request other context's methods that required authenticataion. No need to store any credentials . Everything is handled by the SDK
        print("Loged-in successfully")
    }else{
        print(hopperError)
    }
})
```
Developed By
------------

[Cryptohopper](https://www.cryptohopper.com/)
