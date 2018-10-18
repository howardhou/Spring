package com.example.geoipdemo.controller;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@RestController
public class GeoIPController {


    @RequestMapping("/getCityFromDb")
    public void getCityFromDb(String ip) throws IOException, GeoIp2Exception {
        // A File object pointing to your GeoIP2 or GeoLite2 database
        File database = new File("/Users/dongdong/Java/GeoLite2-City_20181016/GeoLite2-City.mmdb");

        // This creates the DatabaseReader object. To improve performance, reuse
// the object across lookups. The object is thread-safe.
        DatabaseReader reader = new DatabaseReader.Builder(database).build();

        // 43.254.226.99
        // "128.101.101.101"
        InetAddress ipAddress = InetAddress.getByName(ip);

// Replace "city" with the appropriate method for your database, e.g.,
// "country".
        CityResponse response = reader.city(ipAddress);

        Country country = response.getCountry();
        System.out.println(country.getIsoCode());            // 'US'
        System.out.println(country.getName());               // 'United States'
        System.out.println(country.getNames().get("zh-CN")); // '美国'

        Subdivision subdivision = response.getMostSpecificSubdivision();
        System.out.println(subdivision.getName());    // 'Minnesota'
        System.out.println(subdivision.getIsoCode()); // 'MN'

        City city = response.getCity();
        System.out.println(city.getName()); // 'Minneapolis'

        Postal postal = response.getPostal();
        System.out.println(postal.getCode()); // '55455'

        Location location = response.getLocation();
        System.out.println(location.getLatitude());  // 44.9733
        System.out.println(location.getLongitude()); // -93.2323
    }

    @RequestMapping("/getCityFromService")
    public void getCityFromService(String ip) throws IOException, GeoIp2Exception {
        try (WebServiceClient client = new WebServiceClient.Builder(42, "license_key")
                .build()) {

            // "128.101.101.101"
            InetAddress ipAddress = InetAddress.getByName(ip);

            // Do the lookup
            CityResponse response = client.city(ipAddress);

            Country country = response.getCountry();
            System.out.println(country.getIsoCode());            // 'US'
            System.out.println(country.getName());               // 'United States'
            System.out.println(country.getNames().get("zh-CN")); // '美国'

            Subdivision subdivision = response.getMostSpecificSubdivision();
            System.out.println(subdivision.getName());       // 'Minnesota'
            System.out.println(subdivision.getIsoCode());    // 'MN'

            City city = response.getCity();
            System.out.println(city.getName());       // 'Minneapolis'

            Postal postal = response.getPostal();
            System.out.println(postal.getCode());       // '55455'

            Location location = response.getLocation();
            System.out.println(location.getLatitude());        // 44.9733
            System.out.println(location.getLongitude());       // -93.2323
        }
    }
}
