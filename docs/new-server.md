1. Conseguir server (Debian 10).
2. Añadir credenciales servidor a bitbucket snippet.
3. Añadir despliegue a la pipeline.


4. SECUENCIA:

apt update
apt upgrade
apt install sudo -y
useradd deployments; echo 'deployments:R*lbvfcqj49whbuco2I80Kl6U%6Ea1&'|chpasswd
mkdir -p /var/deployments
sudo chown -R deployments /var/deployments
mkdir -p /home/deployments/.ssh/
echo "-----BEGIN RSA PRIVATE KEY-----
      MIIEowIBAAKCAQEAu2evRxWHfmJSOkRF5PChP/0HgRhBr3syFjgSswxAkLvdFeGg
      YuTlWoXLpo5xKZz5XnhtbiQo9O5VgIIdTI0O+377/TMBogjeQ/msvMxrGh4NFKGj
      lLv2YDOKUfcFB0IzpEGRlsEN4y1Qtvoh/5P+tes1CM7Rt10D44odi9GgghFxRr4O
      0Fop5/NleIfSuDc0iR91A1KeIXg6B+ZksN3OPmhwjdJrMeNBT0eLbJZS9JDTUcxP
      QqZzeehcKVAiokZQS3lHGbS0GT4kaLCXKeS+50XWi0G6esYIOoQf/LBWFHPWWC9u
      44sZ0vGxZYzWLxtrkzKocT9UXFZTTnFEl3ooYQIDAQABAoIBAHiQ/TgbRr9tm/82
      e00N7n/PVuub4m52MMQQsR8V69fxtQvly5y0LEYvu9Rc4brm7Zv0mFp60wq45rM1
      gooEWjY8/PtpvEw1rmFHGPWiAemcmcfDMg13W8uKfRu8czS3R6gOMw8tBrU4Kyx9
      AjB+UylQuB8Bh/SS1/Skn9ubMstaOOvX3dPPjkl+QlmfKG2JkENqXv71Ekllt9ie
      brGsMj1bYvw+17eW1/+om+9zHAM1NMh2vAvAlmf1/7t7msOeE+VfrrhivLxpqLPp
      PeFtPtzLdStJR/hWdaQY+O4WhgfRKYKBd6kR3bDwG8n1MfKCm0O2Or/xh9gjAqiI
      23d1R5ECgYEA6oHSbTGuL87x9NIKx/6JtaEpbx6GhiZ2mSUg7gkwtZdVgrburj3p
      ZJDHo97sTU6zam6cS3LEmfWaEVfX4Rh1a6K2ajIXzm8CLyVu/qzIrLqT+DQSr4Qp
      nRDlQWEG94b60tIkCUspWg6W8ZUQOHOiBjvd8eA5C0AoTgRZmN5QQRUCgYEAzJS3
      /Ne07pwaFf6x1CeqiLGaghy0bk4BkPa+1l/RjRkQ2bhZocxB/wvJ0UUdCoJnrIck
      1wSyJMDw8S9tRuRoBSbu4ck0AhqR5uM6Gr8Qw4cnnFMmQWwn8JJ02nkOboA3kj8U
      NLJgps0th3NdmLZ8ajPejKvAF52lnyqoAbI/5R0CgYEA1aDKRvr5CUhmlnY5qBMy
      9CkKi9WtCsxDQiPWqcHpg6OHHHr1V/nCggB6Pcg4T/yf6Rc2fmzguLhKT/5MBRy4
      6wLhVkCn+0CZJsXdJVfVv7SAU51sYEPvfMwFbNes9xUZrbANcAHue8HKs+ztR9/e
      +/rRpyRyEtOxY9EGpgHv7jkCgYBq0YAbwdlT+SfZsinR14BAbVN6elhve8VvlpZg
      QpmcrajRtWL/izIuZE5VOVwHf714JPxEVMxbSm7Dz/qj2GDDx+dU9wRz0MG7p4tQ
      KdEr9qblBblk0X8tKpte83RomAPsFYmMVlMG5PzPy5nkQexGW5zpIEhlTEgNCm28
      rQCVtQKBgBEHO5GxbiLnjZW9pJWD7cDz11N4O6wyQaPY0pveNkWd7zSIrPdC3m8e
      SvzMsks4ACo1LngWd7Ai1m2ut3YUvGVWdZXGt+uXMbqDhTEZIbotSR332+VUdpHb
      GMchaIH14eUaCQLhZwzaNgrgE0xnifUgS4SC4oYX+RsRVz7eHL8g
      -----END RSA PRIVATE KEY-----" > /home/deployments/.ssh/id_rsa
echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC7Z69HFYd+YlI6REXk8KE//QeBGEGvezIWOBKzDECQu90V4aBi5OVahcumjnEpnPleeG1uJCj07lWAgh1MjQ77fvv9MwGiCN5D+ay8zGsaHg0UoaOUu/ZgM4pR9wUHQjOkQZGWwQ3jLVC2+iH/k/616zUIztG3XQPjih2L0aCCEXFGvg7QWinn82V4h9K4NzSJH3UDUp4heDoH5mSw3c4+aHCN0msx40FPR4tsllL0kNNRzE9CpnN56FwpUCKiRlBLeUcZtLQZPiRosJcp5L7nRdaLQbp6xgg6hB/8sFYUc9ZYL27jixnS8bFljNYvG2uTMqhxP1RcVlNOcUSXeihh root@vmi244575.contaboserver.net" > /home/deployments/.ssh/id_rsa.pub
echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC7Z69HFYd+YlI6REXk8KE//QeBGEGvezIWOBKzDECQu90V4aBi5OVahcumjnEpnPleeG1uJCj07lWAgh1MjQ77fvv9MwGiCN5D+ay8zGsaHg0UoaOUu/ZgM4pR9wUHQjOkQZGWwQ3jLVC2+iH/k/616zUIztG3XQPjih2L0aCCEXFGvg7QWinn82V4h9K4NzSJH3UDUp4heDoH5mSw3c4+aHCN0msx40FPR4tsllL0kNNRzE9CpnN56FwpUCKiRlBLeUcZtLQZPiRosJcp5L7nRdaLQbp6xgg6hB/8sFYUc9ZYL27jixnS8bFljNYvG2uTMqhxP1RcVlNOcUSXeihh root@vmi244575.contaboserver.net" >> /home/deployments/.ssh/authorized_keys
sudo chown -R deployments /home/deployments/.ssh/

echo "PUBLIC KEY FOR "