# Hashing by using SHA-256 with JAVA
  The SHA (Secure Hash Algorithm) is one of the popular cryptographic hash functions. A cryptographic hash can be used to make a signature for a text or a data file. 

  The SHA-256 algorithm generates an almost-unique, fixed-size 256-bit (32-byte) hash. This is a one-way function, so the result cannot be decrypted back to the original value.

# Requirement
* Apache NetBeans IDE 13
* JDK 1.8

# Usage
## SHA-256

* Import some library needed for Hashing
```Java
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
```

* Java provide inbuilt `MessageDigest` class for SHA-256 Hashing
```Java
MessageDigest md = MessageDigest.getInstance("SHA-256");
```

* Next we will be creating a new instance for the `SecureRandom` class and the `nextByte()` method generates the random salt.
```Java
SecureRandom random = new SecureRandom();
byte[] salt = new byte[16];
random.nextBytes(salt);
```

* We add salt to input string using the `update()` method of `MessageDigest`:
```Java
md.update();
```

* Once we have added the salt, we can generate the hashed the input by using the `digest()` method:
```Java
byte[] bytes = md.digest(input.getBytes());
```

* Convert `byte[]` into a string as:
```Java
// Convert byte array into signum representation
BigInteger number = new BigInteger(1, hash);

// Convert message digest into hex value
StringBuilder hexString = new StringBuilder(number.toString(16));

// Pad with leading zeros
while (hexString.length() < 64) {
     hexString.insert(0, '0');
}

generateString = hexString.toString();
```

For example, if we input string "abc" without using the salt, the hashed string result is:
```
Hashed string using SHA-256 without salt: ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad
```

or if we input string "abc" and input salt "salt", the hashed string result is:
```
Hashed string using SHA-256 with salt = "salt": 3681099918be28c95b81e27e7e5c2e4c6a6dea566d2d10e7f49139ebb779eb6f
```

## About

### MessageDigest
* `public abstract class MessageDigest extends MessageDigestSpi`
* This MessageDigest class provides applications the functionality of a message digest algorithm, such as SHA-1 or SHA-256. Message digests are secure one-way hash functions that take arbitrary-sized data and output a fixed-length hash value.
* More info: [Class MessageDigest](https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html)
### SecureRandom
* `public class SecureRandom extends Random`
* This class provides a cryptographically strong random number generator (RNG).
* More info: [Class SecureRandom](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html)