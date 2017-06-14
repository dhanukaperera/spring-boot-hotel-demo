package rc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dhanuka Perera on 6/13/2017.
 */
@Component
public class DbSeeder implements CommandLineRunner {

    private  HotelRepositoroy hotelRepositoroy;

    public DbSeeder(HotelRepositoroy hotelRepositoroy) {
        this.hotelRepositoroy = hotelRepositoroy;
    }

    @Override
    public void run(String... strings) throws  Exception{
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris","France"),
                Arrays.asList(
                        new Review("John",8,false),
                        new Review("dhanuka",9,true)
                )
        );

        Hotel ibs = new Hotel(
                "ibs",
                145,
                new Address("Bucharset","Rumaniya"),
                Arrays.asList(
                        new Review("dil",9,true)
                )
        );

        Hotel BeackLake = new Hotel(
                "Beach Lake",
                160,
                new Address("Beach Lake","Sri Lanaka"),
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepositoroy.deleteAll();

        // add hotels to db
        List<Hotel> hotels =  Arrays.asList(marriot,ibs,BeackLake);
        this.hotelRepositoroy.save(hotels);
    }
}
