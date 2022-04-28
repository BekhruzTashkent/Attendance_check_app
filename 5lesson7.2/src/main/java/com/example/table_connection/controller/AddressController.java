package com.example.table_connection.controller;

import com.example.table_connection.entity.*;
import com.example.table_connection.payload.AddressDto;
import com.example.table_connection.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController { //hello world
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    ContinentRepository continentRepository;
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    StudentRepository studentRepository;


    @RequestMapping(value = "/address", method = RequestMethod.GET)  //read
    public List<Address> readAddress(){
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)  //create
    public String createAddress(@RequestBody AddressDto addressDto){

        Continent continent = new Continent();
        continent.setQita(addressDto.getQita());
        Continent saveContinent = continentRepository.save(continent);

        Country country = new Country();
        country.setDavalt(addressDto.getDavlat());
        country.setContinent(saveContinent);
        Country saveCountry = countryRepository.save(country);

        Region region = new Region();
        region.setViloyat(addressDto.getViloyat());
        region.setCountry(saveCountry);
        Region saveRegion = regionRepository.save(region);

        District district = new District();
        district.setTuman(addressDto.getTuman());
        district.setRegion(saveRegion);
        District saveDistrict = districtRepository.save(district);

        Address address = new Address();
        address.setKocha(addressDto.getKocha());
        address.setUyRaqami(addressDto.getUyRaqami());
        address.setDistrict(saveDistrict);
        Address save = addressRepository.save(address);

        University university = new University();
        university.setName(addressDto.getName());
        university.setAddress(save);
        University saveUniversity = universityRepository.save(university);

        Student student = new Student();
        student.setFirstName(addressDto.getFirstName());
        student.setLastName(addressDto.getLastName());
        student.setUniversity(saveUniversity);
        studentRepository.save(student);

        return "Address added";

    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)  //delete
    public String deleteAddress(@PathVariable Integer id){
        addressRepository.deleteById(id);
        return "deleted successfully";
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    public String updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()){

            Continent continent = new Continent();
            continent.setQita(addressDto.getQita());
            Continent saveContinent = continentRepository.save(continent);

            Country country = new Country();
            country.setDavalt(addressDto.getDavlat());
            country.setContinent(saveContinent);
            Country saveCountry = countryRepository.save(country);

            Region region = new Region();
            region.setViloyat(addressDto.getViloyat());
            region.setCountry(saveCountry);
            Region saveRegion = regionRepository.save(region);

            District district = new District();
            district.setTuman(addressDto.getTuman());
            district.setRegion(saveRegion);
            District saveDistrict = districtRepository.save(district);

            Address address = optionalAddress.get();
            address.setKocha(addressDto.getKocha());
            address.setUyRaqami(addressDto.getUyRaqami());
            address.setDistrict(saveDistrict);
            addressRepository.save(address);

            return "Updated successfully";
        }
        else{
            return "Not found";
        }
    }


}
