# encryptionStudy
常见的加密算法学习.

# 加密算法分类,what
加密算法就是就是将数据用算法进行处理,变成不可读的密文. 解密是通过密钥来显示原本的内容,从而保护数据不被人窃取.
加密算法通常分为两大类,对称加密和非对称加密.
对称加密就是使用同一个密钥(session key)去加密和解密.DES/AES(用来替代DES)就是一种典型的对称加密算法.
非对称加密,就是有两个钥匙--公钥和私钥,公钥用来对数据加密,公钥可以用来传播,私钥就会对密文进行解密,只有解密的人才知道.RSA是典型的非对称加密算法.
RSA是第一个既能用于数据加密也能够用于数字签名的算法.

MD5不算加密算法(没有解密算法),只能说是摘要算法,用哈希函数对一段信息产生摘要信息.将任意长度的字节串变换为128bit的字符串.
可以用来对文件进行签名,确定文件是否修改过,以及防止文件作者的抵赖.
之前说MD5可以用来对密码散列,然后存储. 但是由于对短密码进行MD5加密,然后索引起来(彩虹表),随着彩虹表的不断扩大,MD5就变得不再安全.
虽然通过加盐(salt)的方式,或者两次md5的方式可以提高破解的难度,但是密码可以拿到,算法可能也可以拿到,这样还是可以解密出密码.

sha1和MD5一样,是很流行的信息摘要算法,比MD5安全性更高,信息摘要算法都是有碰撞的(不同的东西,算出来的信息摘要相同).
但是 安全性高的算法,用公式去计算碰撞是很困难的.
拿到sha1的算法之后,也可以搞一个简单密码的索引,去对比获取简单密码的账户.(暴力破解).

Base64,是将一个字符串或者二进制数据编码为较短的字符串,并且不可读.

# 算法使用, how


# 算法原理,why
* RSA算法基于一个十分简单的数论事实:将两个大素数相乘十分容易,但是想要对乘积进行因式分解却极其困难.



# 常见的应用场景
* HTTPS,数字证书;
* 账号的密码存储,使用不可逆的加密算法,存最终的hash结果.


# todo
对称des和aes例子
数字摘要/数字签名的区别,https的数字证书,以及https安全的原因.