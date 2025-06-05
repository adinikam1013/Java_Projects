# 🔐 Java Encryption/Decryption Tool

A Java console application that provides:
- Caesar Cipher encryption
- AES encryption using a 16-character key
- Option to save encrypted text to a file

---

## 🚀 How to Run on GitHub Codespaces

### 📁 Project Structure

EncryptionTool/
├── src/
│ ├── Main.java
│ ├── CaesarCipher.java
│ └── AESEncryption.java
├── output/
│ └── encrypted.txt (optional output)

---

## ✅ Features

- 🔄 Encrypt text using Caesar or AES
- 📂 Optionally saves encrypted text to `output/encrypted.txt`
- 🧠 Simple UI with command-line prompts

---

## 🛠️ Setup Instructions

1. **Open GitHub Codespaces**
2. **Clone this repo** or create a new repo and upload files
3. **Compile** the Java files:
   ```bash
   cd src
   javac *.java

Run the application:
java Main

🔐 Caesar Cipher Mode
Enter a key (integer)
Shifts letters based on the key

🔐 AES Mode
Enter a 16-character key (e.g., 1234567890abcdef)
Uses AES-128 encryption (ECB mode with padding)

📁 Output File
If selected, the encrypted output is saved to:
output/encrypted.txt

📜 Example
Choose Mode: 1. Caesar Cipher  2. AES Encryption
1
Enter text: HELLO
Enter Caesar key (int): 3
Encrypted Text: KHOOR
Save to file? (yes/no): yes
Saved to output/encrypted.txt

🧠 Author
Aditya | https://github/adinikam1013

