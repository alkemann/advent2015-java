package com.alkemann.advent.four;

import com.alkemann.advent.common.exceptions.FailedToGenerateMd5Exception;
import com.alkemann.advent.common.exceptions.TooManyFailuresException;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solver {

    int mine(String secret) throws TooManyFailuresException, FailedToGenerateMd5Exception {
        return mine(secret, 5);
    }

    int mine(String secret, int n) throws TooManyFailuresException, FailedToGenerateMd5Exception {
        String md5, str;
        int counter = 0;
        while (true) {
            try {
                str = secret + Integer.toString(counter);
                md5 = md5(str);
            } catch (Exception ex) {
                throw new FailedToGenerateMd5Exception();
            }
            if (check(md5, n)) return counter;
            counter++;
            if (counter > 12489700) throw new TooManyFailuresException(); // "There has been too many failures, even after 100 attempts"
        }
    }

    // defaults the number of 0s to look for to 5
    boolean check(String md5) {
        return check(md5, 5);
    }

    boolean check(String md5, int n) {
        while (n-- > 0) {
            if (md5.charAt(n) != '0') {
                return false;
            }
        }
        return true;
    }

    String md5(String value) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(value.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

}
