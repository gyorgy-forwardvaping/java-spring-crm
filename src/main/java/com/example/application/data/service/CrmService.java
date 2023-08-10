/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.application.data.service;


import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 *
 * @author george
 */
@Service
public class CrmService {
    
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;
    
    public CrmService(ContactRepository contactRepository,
                      CompanyRepository companyRepository,
                      StatusRepository statusRepository) { 
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }
    
    public List<Contact> findAllContacts(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) { 
            return contactRepository.findAll();
        } else {
            return contactRepository.search(stringFilter);
        }
    }
    
    public long countContacts() {
        return contactRepository.count();
    }
    
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
    
    public void saveContact(Contact contact) {
        if (contact == null) {
            System.err.println("Contact is null");
            return;
        }
        
        contactRepository.save(contact);
    }
    
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }
    
    public List<Status> findAllStatuses(){
        return statusRepository.findAll();
    }
}
