package com.petapplication.requestDTO;

import com.petapplication.utility.ModelBase;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

@Getter
@Setter
public class PetInfoRequestDTO extends ModelBase {

    private Long id;

//    @NotEmpty(message = "Dog name field can't be empty")
    @Size(min = 2, max = 50, message = "Dog name size must be between {min} and {max}")
    private String name;

//    @NotEmpty(message = "Owner name field can't be empty")
    @Size(min = 2, max = 50, message = "Owner name size must be between {min} and {max}")
    private String ownerName;

//    @NotEmpty(message = "Owner No field can't be empty")
    @Size(min = 2, max = 50, message = "Owner number must be between {min} and {max}")
    private String ownerNo;

    @Email(message = "Owner email can't be empty")
    private String ownerEmail;

//    @NotEmpty(message = "Address field can't be empty")
    @Size(min = 2, max = 50, message = "Address must be between {min} and {max}")
    private String address;

    private Character status;

    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNo() {
        return ownerNo;
    }

    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
