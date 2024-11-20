package models;

public class Location {

    private String name;
    private String addrress;
    private String mapAddress;
    private String contact;
    private String email;

    

    public Location(String name, String addrress, String contact, String email) {
        this.name = name;
        this.addrress = addrress;
        this.contact = contact;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddrress() {
        return addrress;
    }
    public void setAddrress(String addrress) {
        this.addrress = addrress;
    }
    public String getMapAddress() {
        return mapAddress;
    }
    public void setMapAddress(String mapAddress) {
        this.mapAddress = mapAddress;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((addrress == null) ? 0 : addrress.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (addrress == null) {
            if (other.addrress != null)
                return false;
        } else if (!addrress.equals(other.addrress))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    
    
}
