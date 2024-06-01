============================Generete private key ================================
openssl genpkey -algorithm RSA -out private_key.key -aes256


=================================Gnerete a .csr ==============================================
openssl req -new -key private_key.key -out request.csr

============================CREATE CERTIFICATE PEM ========================================
openssl x509 -req -in resques.csr -signkey private_key.key -out certificate.pem -days 365 -extensions SAN -extfile <(printf "[SAN]\nsubjectAltName=DNS:localhost")


=========================================Crate a p12 bundle =======================================
openssl pkcs12 -export -out certificate.p12 -inkey private_key.key -in certificate.pem -name test
