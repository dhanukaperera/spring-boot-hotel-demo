package rc;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dhanuka Perera on 6/13/2017.
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelRepositoroy hotelRepositoroy;

    public HotelController(HotelRepositoroy hotelRepositoroy) {
        this.hotelRepositoroy = hotelRepositoroy;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels =  this.hotelRepositoroy.findAll();
        return hotels;
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepositoroy.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelRepositoroy.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")String id){
        this.hotelRepositoroy.delete(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Hotel hotel = this.hotelRepositoroy.findById(id);
        return  hotel;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        List<Hotel> hotels = this.hotelRepositoroy.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city)
    {
        List<Hotel> hotels = this.hotelRepositoroy.findByCity(city);
        return hotels;
    }

}
