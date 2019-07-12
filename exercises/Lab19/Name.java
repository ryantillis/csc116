/**
 * Name Class to represent persons name
 *
 * @author Thomas Tillis
 */
public class Name {
    private String firstName;
    private String lastName;
    private char middleInitial;

    /**
     * Name Constructor with fields
     */
    public Name(String firstName, String lastName, char middleInitial) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
    }

    /**
     * Name Constructor 
     */
    public Name() {

    }

    /**
     * Set first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set middle initial
     */
    public void setMiddle(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * get first name
     */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * get last name
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * get middle initial
     */
    public char getMiddle() {
        return this.middleInitial;
    }
   /**
     * get normal order as string
     */
    public String getNormalOrder() {
        return firstName + " " + middleInitial + ". " + lastName;
    }
   /**
     * get reverse order as string
     */
    public String getReverseOrder() {
        return lastName + ", " + firstName + " " +  middleInitial + ".";
    }
   /**
     * get string
     */
    public String toString() {
        return firstName + " " + middleInitial + ". " + lastName;
    }
   /**
     * test equals
     */
    public boolean equals(Name otherName) {
        boolean sameFirst = otherName.getFirstName() == this.getFirstName();
        boolean sameMiddle = otherName.getMiddle() == this.getMiddle();
         boolean sameLast = otherName.getLastName() == this.getLastName();
        if(sameFirst && sameMiddle && sameLast) {
            return true;
        }
        return false;
    }

}