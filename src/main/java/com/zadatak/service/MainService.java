package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zadatak.daoimpl.AddressDao;
import com.zadatak.daoimpl.CityDao;
import com.zadatak.daoimpl.ContactDao;
import com.zadatak.daoimpl.CountryDao;
import com.zadatak.daoimpl.SexDao;
import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.domain.Sex;

@Service
@Transactional
public class MainService implements ServiceBase {

	@Autowired
	private ContactDao contactDAO;
	@Autowired
	private SexDao sexDAO;
	@Autowired
	private AddressDao addressDAO;
	@Autowired
	private CityDao cityDAO;
	@Autowired
	private CountryDao countryDAO;

	public MainService() {
	}

	@Override
	public List<Contact> getContacts() {
		return contactDAO.findAll();

	}

	@Override
	public List<Address> getAddresses() {
		return addressDAO.findAll();

	}

	@Override
	public List<City> getCities() {
		return cityDAO.findAll();

	}

	@Override
	public List<Sex> getSexs() {
		List<Sex> sexs = sexDAO.findAll();
		return sexs;
	}

	@Override
	public List<Country> getCountry() {
		List<Country> countries = countryDAO.findAll();
		return countries;
	}

	@Override
	public String saveNewContact(Contact contact) {
		String error = "";
		if (contact != null) {
			boolean check = contactExists(contact);
			if (!check) {
				contactDAO.save(contact);
				error = contact.getFirstName() + " " + contact.getLastName() + " added succesfully.";
			} else {
				error = "This contact exist in database.";
			}
		}
		return error;
	}

	public boolean contactExists(Contact contact) {
		List<Contact> contacts = contactDAO.findAll();
		return contacts.iterator().next().equals(contact);
	}

	@Override
	public String saveNewAddress(Address address) {
		String error = "";
		if (address != null) {
			boolean check = addressExists(address);
			if (!check) {
				addressDAO.save(address);
				error = address.getStreet() + " added sucessfully.";
			} else {
				error = "This address exist in database.";
			}
		}
		return error;
	}

	public boolean addressExists(Address address) {
		List<Address> addresses = addressDAO.findAll();
		boolean check = false;
		for (Address addressDatabase : addresses) {
			if (address.equals(addressDatabase))
				check = true;
		}
		return check;
	}

	@Override
	public String saveNewCity(City city) {
		String error = "";
		if (city != null) {
			boolean check = cityExists(city);
			if (!check) {
				cityDAO.save(city);
				error = city.getName() + " added succesfully.";
			} else {
				error = "This address exist in database.";
			}
		}
		return error;
	}

	public boolean cityExists(City city) {
		List<City> cities = cityDAO.findAll();
		boolean check = false;
		for (City cityDatabase : cities) {
			if (city.equals(cityDatabase))
				check = true;
		}
		return check;
	}

	@Override
	public void deleteContact(long contactId) {
		contactDAO.deleteById(contactId);
	}

	@Override
	public String deleteAddress(long addressId) {

		List<Contact> contacts = contactDAO.findAll();
		boolean check = false;
		for (Contact contact : contacts) {
			if (contact.getAddressID() == addressId)
				check = true;
		}

		if (!check) {
			addressDAO.deleteById(addressId);
			return "Address deleted.";
		} else {
			Address address = addressDAO.getByKey(addressId);
			return "Address " + address.getStreet() + " " + address.getStreetNumber() + " can't be deleted..";
		}
	}

	@Override
	public String deleteCity(long cityId) {

		List<Address> addresses = addressDAO.findAll();
		boolean check = false;
		for (Address address : addresses) {
			if (address.getCity() == cityDAO.getByKey(cityId))
				check = true;
		}

		if (!check) {
			cityDAO.deleteById(cityId);
			return "City deleted.";
		} else {
			City city = cityDAO.getByKey(cityId);
			return "City " + city.getName() + " can't be deleted.";
		}
	}

	@Override
	public String deleteCountry(long countryId) {

		List<City> cities = cityDAO.findAll();
		boolean check = false;
		for (City city : cities) {
			if (city.getCountry() == countryDAO.getByKey(countryId))
				check = true;
		}

		if (!check) {
			countryDAO.deleteById(countryId);
			return "Country deleted.";
		} else {
			Country country = countryDAO.getByKey(countryId);
			return "Country " + country.getName() + " can't be deleted.";
		}
	}

	public City prepareCity(long cityId) {
		City city = cityDAO.getByKey(cityId);
		return city;
	}

	@Override
	public Contact prepareContact(long contactId) {
		return contactDAO.getByKey(contactId);
	}

	@Override
	public Address prepareAddress(long addressId) {
		Address address = addressDAO.getByKey(addressId);
		return address;
	}

	@Override
	public String saveNewCountry(Country country){
		String error = "";
		if (country != null) {
			boolean check = countryExists(country);
			if (check) {
				countryDAO.save(country);
				error = country.getName() + " added sucessfully.";
			} else {
				error = "This country exist in database.";
			}
		}
		return error;
	}

	private boolean countryExists(Country country) {
		List<Country> countries = countryDAO.findAll();
		boolean check = false;
		for (Country countryDatabase : countries) {
			if (country.equals(countryDatabase))
				check = true;
		}
		return check;
	}

	public String saveUpdatedCity(City city) {
		cityDAO.update(city);
		return "succes";
	}

	public String saveUpdatedContact(Contact contact) {
		contactDAO.update(contact);
		return "succes";
	}

	public String saveUpdatedAddress(Address address) {
		addressDAO.update(address);
		return "succes";
	}
}
