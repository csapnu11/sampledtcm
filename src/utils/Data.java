package utils;



import java.util.ArrayList;
import java.util.List;

import models.Location;
import models.Region;

public class Data {
        
    public static List<Region> LOCATION_DATA = generateData();

    public static String SITE_URL = "https://datacom.com/nz/en/contact-us";
    
    private static List<Region> generateData() {

        List<Region> data = new ArrayList<>();
        // main locs
        Region newZealand = generateNewZealandLocations();
        Region australia = generateAustraliaLocations();
        Region asia = generateAsiaLocations();
        
                data.add(newZealand);
                data.add(australia);
                data.add(asia);
                
                return data;
                
    }

    private static Region generateAsiaLocations() {
        Region pLocation = new Region("Asia");
        Location malaysia = new Location(
            "Malaysia",
            "Level 3A, 1 Sentral, Jalan Rakyat, Kuala Lumpur Sentral, Kuala Lumpur 50470",             
            "+60 3 2109 1000",
            "info-kl@datacom.com.au"
        );
        Location philippines = new Location(
            "Philippines",
            "Level 23F, IBM Plaza, 8 Eastwood Ave, Bagumbayan, Quezon City, 1110 Metro Manila, Philippines",             
            "+63 2 717 6300",
            "caracamille.cruz@datacom.com.au"
        );
        Location singapore = new Location(
            "Singapore",
            "38 Beach Road, South Beach Tower, #29-11 Singapore 189767",             
            "+60 3 2109 1000",
            "felicisimo.gadaingan@datacom.com.au"
        );
        
        
        pLocation.getLocations().add(malaysia);
        pLocation.getLocations().add(philippines);
        pLocation.getLocations().add(singapore);

                
        return pLocation;
    }
        

        
    private static Region generateAustraliaLocations() {
        Region pLocation = new Region("Australia");
        Location adelaide = new Location(
            "Adelaide",
            "118 Franklin Street, Adelaide, South Australia 5000",            
            "+61 8 7221 7900",
            "contactsa@datacom.com.au"
        );
        Location brisbane = new Location(
            "Brisbane",
            "501 Ann Street, Fortitude Valley, Brisbane, Queensland 4006",             
            "+61 7 3842 8888",
            "qldsales@datacom.com.au"
        );
        Location canberra = new Location(
            "Canberra",
            "Level 12, Civic Quarter, 68 Northbourne Ave, Canberra, ACT 2601",             
            "+61 2 6112 0200",
            "contactact@datacom.com.au"
        );
        Location melbourne = new Location(
            "Melbourne",
            "Level 11, Two Melbourne Quarter, 697 Collins Street, Docklands, Victoria 3008",             
            "+61 3 9626 9600",
            "vic-reception@datacom.com.au"
        );
        Location modbury = new Location(
            "Modbury",
            "100 Smart Road, Modbury, South Australia 5092",             
            "+61 8 8164 7600",
            "reception.adel@datacom.com.au"
        );
        Location perth = new Location(
            "Perth",
            "Level 11, 66 St. George's Terrace, Perth, Western Australia 6000",             
            "+61 8 6466 6888",
            "wa.clientservices@datacom.com.au"
        );
        Location sydney = new Location(
            "Sydney — Denison Street",
            "Level 31, 1 Denison Street, North Sydney, Sydney, NSW 2060",             
            "+61 2 9023 5000",
            "reception.denison@datacom.com.au"
        );
        Location townsville = new Location(
            "Townsville",
            "Lot 2, 264-278 Woolcock Street, Townsville, Queensland 4810",             
            "+61 7 4728 7800",
            "townsville@datacom.com.au"
        );
        
        pLocation.getLocations().add(adelaide);
        pLocation.getLocations().add(brisbane);
        pLocation.getLocations().add(canberra);
        pLocation.getLocations().add(melbourne);
        pLocation.getLocations().add(modbury);
        pLocation.getLocations().add(perth);
        pLocation.getLocations().add(sydney);
        pLocation.getLocations().add(townsville);
                
        return pLocation;
    }

    private static Region generateNewZealandLocations(){
        Region pLocation = new Region("New Zealand");
        Location auckland = new Location(
            "Auckland",
            "58 Gaunt Street, Auckland CBD, Auckland 1010",             
            "+64 9 303 1489",
            "reception.gaunt@datacom.co.nz"
        );
        Location christchurch = new Location(
            "Christchurch",
            "67 Gloucester Street, Christchurch 8013",             
            "+64 3 379 7775",
            "reception.christchurch@datacom.co.nz"
        );
        Location dunedin = new Location(
            "Dunedin",
            "Level 1, 77 Vogel Street, Dunedin 9011",             
            "+64 3 379 7775",
            "reception.christchurch@datacom.co.nz"
        );
        Location hamilton = new Location(
            "Hamilton",
            "Level 2, 94 Bryce Street, Hamilton 3204",             
            "+64 7 834 1666",
            "reception.hamilton@datacom.co.nz"
        );
        Location hasting = new Location(
            "Hastings",
            "2/117 Heretaunga Street East, Hastings 4122",             
            "+64 6 835 0793",
            "reception.hamilton@datacom.co.nz"
        );
        Location nelson = new Location(
            "Nelson",
            "Level 1, 190 Trafalgar Street, Nelson 7010",             
            "+64 3 546 5558",
            "reception.nelson@datacom.co.nz"
        );
        Location plymouth = new Location(
            "New Plymouth",
            "Level 1, 2 Devon Street East, New Plymouth 4310",             
            "+64 7 834 1666",
            "reception.hamilton@datacom.co.nz"
        );
        Location rotorua = new Location(
            "Rotorua",
            "8 Railway Road, Rotorua 3015",             
            "+64 7 834 1666",
            "reception.hamilton@datacom.co.nz"
        );
        Location tauranga = new Location(
            "Tauranga",
            "15-17 Harington Street, Tauranga 3110",             
            "+64 7 834 1666",
            "reception.tauranga@datacom.co.nz"
        );
        Location wellington = new Location(
            "Wellington",
            "55 Featherston Street, Pipitea, Wellington 6011,",             
            "+64 4 460 1500",
            "reception.wellington@datacom.co.nz"
        );

        pLocation.getLocations().add(auckland);
        pLocation.getLocations().add(christchurch);
        pLocation.getLocations().add(dunedin);
        pLocation.getLocations().add(hamilton);
        pLocation.getLocations().add(hasting);
        pLocation.getLocations().add(nelson);
        pLocation.getLocations().add(plymouth);
        pLocation.getLocations().add(rotorua);
        pLocation.getLocations().add(tauranga);
        pLocation.getLocations().add(wellington);
        return pLocation;
    }
        
        


}

