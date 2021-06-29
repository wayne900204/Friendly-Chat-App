# 標準的 FirebaseStorage + Firebase RealTime Database 的 Sample Code

## Support
- Android

## Step
 - add google-services.json to ```./android/app/google-services.json```
 - enable google login and email login on firebase
## Realtime Database Rule's Security Setting
```shell script
{
  "rules": {
    ".read": "auth.uid != null",  // 2021-7-29
    ".write": "auth.uid != null",  // 2021-7-29
  }
}
```

## References
- [Friendly Chat](https://firebase.google.com/codelabs/firebase-android#1)
- [Kotlin Codelab Github](https://github.com/firebase/codelab-friendlychat-android)

## Contributing
Bug reports and pull requests are welcome on GitHub at [https://github.com/wayne900204/Friendly-Chat-App.](https://github.com/wayne900204/Friendly-Chat-App)

## AboutMe
[My Github](https://github.com/wayne900204),
📫  Reach me  **wayne900204@gmail.com**
