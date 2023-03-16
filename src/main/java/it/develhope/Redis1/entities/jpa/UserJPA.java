package it.develhope.Redis1.entities.jpa;

import jakarta.persistence.*;

/**
 * @author Drumstyle92
 * Class representing a Java Persistence API (JPA) entity that maps to a
 * table in a relational database used to represent users
 */
@Entity
@Table(name = "user_")
public class UserJPA {

    /**
     * Field that identifies entities, mapped to the table column
     * with the primary key and automatically generated through a sequence
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * Username field mapped to the referenced table column
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * User surname field mapped to the referenced table column
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * User photo field mapped to the referenced table column
     */
    @Column(name = "profile_picture")
    private String profilePicture;

    /**
     * User email field mapped to the referenced table column
     */
    @Column
    private String email;

    /**
     * User email field mapped to the referenced table column
     */
    @Column(name = "password_encrypted")
    private String passwordEncrypted;

    /**
     * User address field mapped to the referenced table column
     */
    @Column(name = "domicile_address")
    private String domicileAddress;

    /**
     * User city field mapped to the referenced table column
     */
    @Column(name = "domicile_city")
    private String domicileCity;

    /**
     * User street number field mapped to the reference table column
     */
    @Column(name = "domicile_number")
    private String domicileNumber;

    /**
     * User state field mapped to the referenced table column
     */
    @Column(name = "domicile_state")
    private String domicileState;

    /**
     * Field of the user's tax code mapped to the referenced table column
     */
    @Column(name = "fiscal_code")
    private String fiscalCode;

    /**
     * Default constructor
     */
    public UserJPA(){}

    /**
     * @param id                the id
     * @param firstName         the first name
     * @param lastName          the last name
     * @param profilePicture    the profile picture
     * @param email             the email
     * @param passwordEncrypted the password encrypted
     * @param domicileAddress   the domicile address
     * @param domicileCity      the domicile city
     * @param domicileNumber    the domicile number
     * @param domicileState     the domicile state
     * @param fiscalCode        the fiscal code
     * Parameterized constructor
     */
    public UserJPA(Long id, String firstName, String lastName, String profilePicture,
                   String email, String passwordEncrypted, String domicileAddress,
                   String domicileCity, String domicileNumber, String domicileState, String fiscalCode) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.email = email;
        this.passwordEncrypted = passwordEncrypted;
        this.domicileAddress = domicileAddress;
        this.domicileCity = domicileCity;
        this.domicileNumber = domicileNumber;
        this.domicileState = domicileState;
        this.fiscalCode = fiscalCode;

    }

    /**
     * @return the id
     * Method for encapsulation
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id
     * Method for encapsulation
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the first name
     * Method for encapsulation
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the first name
     * Method for encapsulation
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the last name
     * Method for encapsulation
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the last name
     * Method for encapsulation
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the profile picture
     * Method for encapsulation
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * @param profilePicture the profile picture
     * Method for encapsulation
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * @return the email
     * Method for encapsulation
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email
     * Method for encapsulation
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password encrypted
     * Method for encapsulation
     */
    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    /**
     * @param passwordEncrypted the password encrypted
     * Method for encapsulation
     */
    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    /**
     * @return the domicile address
     * Method for encapsulation
     */
    public String getDomicileAddress() {
        return domicileAddress;
    }

    /**
     * @param domicileAddress the domicile address
     * Method for encapsulation
     */
    public void setDomicileAddress(String domicileAddress) {
        this.domicileAddress = domicileAddress;
    }

    /**
     * @return the domicile city
     * Method for encapsulation
     */
    public String getDomicileCity() {
        return domicileCity;
    }

    /**
     * @param domicileCity the domicile city
     * Method for encapsulation
     */
    public void setDomicileCity(String domicileCity) {
        this.domicileCity = domicileCity;
    }

    /**
     * @return the domicile number
     * Method for encapsulation
     */
    public String getDomicileNumber() {
        return domicileNumber;
    }

    /**
     * @param domicileNumber the domicile number
     * Method for encapsulation
     */
    public void setDomicileNumber(String domicileNumber) {
        this.domicileNumber = domicileNumber;
    }

    /**
     * @return the domicile state
     * Method for encapsulation
     */
    public String getDomicileState() {
        return domicileState;
    }

    /**
     * @param domicileState the domicile state
     * Method for encapsulation
     */
    public void setDomicileState(String domicileState) {
        this.domicileState = domicileState;
    }

    /**
     * @return the fiscal code
     * Method for encapsulation
     */
    public String getFiscalCode() {
        return fiscalCode;
    }

    /**
     * @param fiscalCode the fiscal code
     * Method for encapsulation
     */
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

}

