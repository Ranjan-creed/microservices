package com.example.user.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class ChecksumUtil {

    public static String getEncodedCheckSum()
    {
        String defaultChecksum="Pass_123";
        String encodeChecksum=new BCryptPasswordEncoder().encode(defaultChecksum);
        log.info("Encoded Default checksum :::: {}", new BCryptPasswordEncoder().matches(defaultChecksum,encodeChecksum));
        return encodeChecksum;
    }

    public static Boolean checkUserCheckSum(String authCheckSum, String userCheckSum)
    {
        return new BCryptPasswordEncoder().matches(userCheckSum,authCheckSum);
    }
}
