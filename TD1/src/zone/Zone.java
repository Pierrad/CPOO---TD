package zone;

import dispositif.Dispositif;

import java.util.Set;

/** Classe de Zone
 * @author CAPARROS Damien
 **/

public class Zone implements IZone
{
	private String name;
	private String description;
	private Set<Dispositif> dispositifs;

    /**
     * Constructeur par défaut.
     * @param zoneName
     * @param desc
     */
    public Zone(String zoneName, String desc)
    {
    	name = zoneName;
    	description = desc;
    }
    /**
     * Constructeur par défaut sans description.
     * @param zoneName
     */
    public Zone(String zoneName)
    {
    	name = zoneName;
    	description = null;
    }

    /**
    * Obtenir le nom.
    * @return name
    **/
    public String getName()
    {
        return name;
    }

    /**
     * Obtenir la description.
     * @return description
     **/
    public String getDesc()
    {
        return description;
    }

    /**
     * Changer le nom.
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Changer la description.
     * @param desc
     */
    public void setDesc(String desc)
    {
    	this.description = desc;
    }

    /*public Set<Dispositif> getDispositifs()
    {
        return dispositifs;
    }

    public void setDispositifs(Set<Dispositif> dispositifs)
    {
        this.dispositifs = dispositifs;
    }*/

    /**
     * Voir la liste de tous les dispositifs.
     * @return Liste
     **/
    public void listDispositif()
    {

    }

    /**
     * Voir la liste de tous les dispositifs dans une zone donnée.
     * @return Liste
     **/
    public void listDispositif(Zone z)
    {

    }


}
