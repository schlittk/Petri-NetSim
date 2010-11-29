/**
 * PetriNetSim
 *
 * @version 1.0     27.11.2010
 * @author Keith Schlittkus 20072082
 */

import java.util.*;
import java.io.Serializable;

/**
 * Eine PetriNetSimStell repr�sentiert ein Stelle in einem Petrinetz. Eine Stelle hat einen Namen
 * und eine aktuelle, eine minimale und eine maximale Markenanzahl. ??and keeps track of its superclasses, associations
 * and dependencies.?? mal sehen ob das n�tig ist
 */
public class PetriNetSimStelle implements Serializable {

    /**
     * Name der Stelle
     */
    private String nameStelle; //myName;
    
    /**
     * Aktuelle Anzahl Marken
     */
    private int aktAnz;
    
    /**
     * Markenanzahl maximal
     */
    private int maxAnz;
    
    /**
     * Markenanzahl minimal
     */
    private int minAnz;
    
    /**
     * Names of attribute in the class
     */
    //private Vector myAttributes;
    
    /**
     * Names of methods in the class
     */
    //private Vector myMethods;
    
    /**
     * Associated classes
     */
    //private Vector myAssociatedClasses;
    
    /**
     * Direct superclasses (multiple inheritance is possible)
     */
    //private Vector mySuperclasses;
    
    /**
     * Classes upon which the current class is dependend
     */
    //private Vector myDependClasses;

    //static final long serialVersionUID = -3748332488864682801L;

    /**
     * Standard Konstruktor erzeuge neue PetriNetSimStelle Instanz
     */
    public PetriNetSimStelle() {
        this("Stelle", 0, 0, 50);
    }

    /**
     * Konstruktor erzeuge neue PetriNetSimStelle Instanz mit gegebenem Namen
     *
     * @param nameStelle Name der Stelle
     * @param aktAnz aktuelle Anzahl Marken
     * @param minAnz minimale Anzahl Marken
     * @param maxAnz maximale Anzahl Marken
     */    
    public PetriNetSimStelle(String nameStelle, int aktAnz, int minAnz, int maxAnz) {
        this.nameStelle = nameStelle;
        this.aktAnz = aktAnz;
        this.minAnz = minAnz;
        this.maxAnz = maxAnz;
        //myAttributes = new Vector();
        //myMethods = new Vector();
        //myAssociatedClasses = new Vector();
        //mySuperclasses = new Vector();
        //myDependClasses = new Vector();
    }

    /**
     * Festlegen des Namens der Stelle. Der Name der Stelle kann ge�ndert werden
     * nachdem eine PetriNetSimStelle erzeugt wurde.
     *
     * @param nameStelle neue Name der Stelle
     */    
    public void setNameStelle(String nameStelle) {
        this.nameStelle = nameStelle;
    }
    
    /**
     * Gibt den namen der Stelle zur�ck
     *
     * @return nameStelle den Namen der Stelle
     */
    public String getNameStelle() {
        return nameStelle;
    }

    /**
     * Gibt die Aktuelle Anzahl Marken zur�ck
     * 
     * @return aktAnz die aktuelle Anzahl der Marken
     */
	public int getAktAnz() {
		return aktAnz;
	}

	/**
	 * Legt fest wie viele Marken auf der Stelle liegen
	 * 
	 * @param aktAnz die aktuelle Anzahl der Marken
	 */
	public void setAktAnz(int aktAnz) {
		this.aktAnz = aktAnz;
	}

	/**
     * Gibt die maximale Anzahl Marken zur�ck
     * 
     * @return maxAnz die maximale Anzahl der Marken
     */
	public int getMaxAnz() {
		return maxAnz;
	}

	/**
	 * Legt fest wie viele Marken maximal auf der Stelle liegen d�rfen
	 * 
	 * @param maxAnz die maximale Anzahl der Marken
	 */
	public void setMaxAnz(int maxAnz) {
		this.maxAnz = maxAnz;
	}

	/**
     * Gibt die minimale Anzahl Marken zur�ck
     * 
     * @return minAnz die minimale Anzahl der Marken
     */
	public int getMinAnz() {
		return minAnz;
	}

	/**
	 * Legt fest wie viele Marken minimal auf der Stelle liegen m�ssen
	 * 
	 * @param minAnz die minimale Anzahl der Marken
	 */
	public void setMinAnz(int minAnz) {
		this.minAnz = minAnz;
	}
        
    /**
     * Add an attribute with a given name
     *
     * @param newAttribute name of an attribute to be added
     */
    /*public void addAttribute(String newAttribute) {
        myAttributes.addElement(newAttribute);
    }*/
    
    /**
     * Remove an attribute with a given name
     *
     * @param oldAttribute name of the attribute to be removed
     */
    /*public void removeAttribute(String oldAttribute) {
        myAttributes.removeElement(oldAttribute);
    }*/

    /**
     * Rename an attribute with a given name if the attribute exists.
     *
     * @param oldAttribute name of the attribute to be renamed
     * @param newAttribute new attribute name
     */
    /*public void renameAttribute(String oldAttribute, String newAttribute) {
        int attributeIndex = myAttributes.indexOf(oldAttribute);
        if (attributeIndex >= 0) {
            myAttributes.removeElementAt(attributeIndex);
            myAttributes.insertElementAt(newAttribute, attributeIndex);
        }
    }*/

    /**
     * Return an iterator over all attribute names
     *
     * @return iterator over all attribute names
     */
    /*public Iterator getAttributes() {
        return myAttributes.iterator();
    }*/

    /**
     * Return the number of attributes in this class
     *
     * @return number of attributes
     */
    /*public int getNumberOfAttributes() {
        return myAttributes.size();
    }*/

    /**
     * Test whether an attribute with a specific name exists in this class already
     *
     * @return true, if the attribute exists, false otherwise
     */
    /*public boolean hasAttribute(String checkAttributeName) {
        return myAttributes.contains(checkAttributeName);
    }*/

    /**
     * Add a method with a given name
     *
     * @param newMethod name of a method to be added
     */        
    /*public void addMethod(String newMethod) {
        myMethods.addElement(newMethod);
    }*/

    /**
     * Remove an method with a given name
     *
     * @param oldMethod name of the method to be removed
     */    
    /*public void removeMethod(String oldMethod) {
        myMethods.removeElement(oldMethod);
    }*/

    /**
     * Rename an method with a given name if the method exists.
     *
     * @param oldMethod name of the method to be renamed
     * @param newMethod new method name
     */    
    /*public void renameMethod(String oldMethod, String newMethod) {
        int methodIndex = myMethods.indexOf(oldMethod);
        if (methodIndex >= 0) {
            myMethods.removeElementAt(methodIndex);
            myMethods.insertElementAt(newMethod, methodIndex);
        }
    }*/

    /**
     * Return an iterator over all method names
     *
     * @return iterator over all method names
     */
    /*public Iterator getMethods() {
        return myMethods.iterator();
    }*/

    /**
     * Return the number of methods in this class
     *
     * @return number of methods
     */
    /*public int getNumberOfMethods() {
        return myMethods.size();
    }*/

    /**
     * Test whether an method with a specific name exists in this class already
     *
     * @return true, if the method exists, false otherwise
     */
    /*public boolean hasMethod(String checkMethodName) {
        return myMethods.contains(checkMethodName);
    }*/

    /**
     * Add another class as associated class.
     *
     * @param newAssociatedClass associated class
     */
    /*public void addAssociation(JModellerClass newAssociatedClass) {
        myAssociatedClasses.add(newAssociatedClass);
    }*/

    /**
     * Remove an associated class.
     *
     * @param oldAssociatedClass associated class to be removed
     */    
    /*public void removeAssociation(JModellerClass oldAssociatedClass) {
        myAssociatedClasses.remove(oldAssociatedClass);
    }*/

    /**
     * Test whether another class is an associated class
     *
     * @return true, if the class is associated, false otherwise
     */
    /*public boolean hasAssociation(JModellerClass checkAssociatedClass) {
        return myAssociatedClasses.contains(checkAssociatedClass);
    }*/

    /**
     * Return an iterator containing all associated classes
     *
     * @return iterator over associated classes
     */    
    /*public Iterator getAssociations() {
        return myAssociatedClasses.iterator();
    }*/

    /**
     * Add another class as superclass. This class becomes a subclass of
     * the other class.
     *
     * @param newSuperclass superclass to be added
     */    
    /*public void addSuperclass(JModellerClass newSuperclass) {
        mySuperclasses.add(newSuperclass);
    }*/
    
    /**
     * Remove a superclass so this class is not longer a subclass of the other class
     *
     * @param oldSuperclass superclass to be removed
     */
    /*public void removeSuperclass(JModellerClass oldSuperclass) {
        mySuperclasses.remove(oldSuperclass);
    }*/

    /**
     * Return an iterator containing all superclasses
     *
     * @return iterator over superclasses
     */
    /*public Iterator getSuperclasses() {
        return mySuperclasses.iterator();
    }*/   

    /**
     * Checks whether class has an inheritance cycle. A inheritance
     * cycle is encountered
     * - if the possible subclass it the same as the current class
     * - if the possible subrclass is already a superclass of the current class
     *
     * @param   possibleSuperclass  class to which should
     */
    /*public boolean hasInheritanceCycle(JModellerClass possibleSubclass) {
        if (possibleSubclass == this) {
            return true;
        }

        return possibleSubclass.isSuperclass(this);

    }*/

    /**
     * Checks whether this class is the superclass of the class to test
     *
     * @param   possibleSubclass    class which should be subclass to this class or its superclasses
     */
    /*public boolean isSuperclass(JModellerClass possibleSubclass) {
        if (possibleSubclass.mySuperclasses.contains(this)) {
            return true;
        }
        
        Iterator i = possibleSubclass.getSuperclasses();
        while (i.hasNext()) {
            Object currentObject = i.next();
            if (isSuperclass((JModellerClass) currentObject)) {
                return true;
            }
        }

        return false;
    }*/

    /**
     * Add another class so this class becomes a dependend class of the other
     *
     * @param newDependency class upon which this class should depend
     */    
    /*public void addDependency(JModellerClass newDependency) {
        myDependClasses.add(newDependency);
    }*/
    
    /**
     * Remove a class on which this class is dependend
     *
     * @param oldDependency dependency class to be removed
     */
    /*public void removeDependency(JModellerClass oldDependency) {
        myDependClasses.remove(oldDependency);
    }*/
    
    /**
     * Test whether this class is dependend on the given class
     *
     * @return true, if this class is dependend, false otherwise
     */
    /*public boolean hasDependency(JModellerClass checkDependency) {
        return myDependClasses.contains(checkDependency);
    }*/
    
    /**
     * Return an iterator containing all classes on which this class is dependend
     *
     * @return iterator over all classes on which this class depends
     */
    /*public Iterator getDependencies() {
        return myDependClasses.iterator();
    }*/
}