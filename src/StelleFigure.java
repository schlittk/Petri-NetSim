/**
 * Petri-NetSim ehemals classfigure
 *
 * @version 1.0     24.11.2010
 * @author Keith Schlittkus
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import CH.ifa.draw.figures.*;
import CH.ifa.draw.standard.*;
import CH.ifa.draw.framework.*;
import CH.ifa.draw.contrib.*;
import CH.ifa.draw.util.*;

/**
 * Kommentar verbessern
 * 
 * A StelleFigure is a graphical representation for a place
 * in a petri net. A StelleFigure separates the graphical
 * representation from the data model. A place has a place
 * name, attributes and methods. Accordingly, a ClassFigure 
 * consists of other parts to edit the class names, attributes
 * and methods respectively.
 *
 * @author Wolfram Kaiser
 */
public class StelleFigure extends GraphicalCompositeFigure {

    /**
     * Grafische Repräsentation der Stelle
     */
    private PetriNetSimStelle  myStelle;

    /**
     * Font used for attribute names
     */
    //private Font            attributeFont;

    /**
     * Font used for method names
     */
    //private Font            methodFont;

    /**
     * Direct reference to a composite figure which stores text figures for attribute names.
     * This figure is also part of this composite container.
     */
    //private GraphicalCompositeFigure    myAttributesFigure;

    /**
     * Direct reference to a composite figure which stores text figures for method names.
     * This figure is also part of this composite container.
     */
    //private GraphicalCompositeFigure    myMethodsFigure;

    /**
     * TextFigure für die Festlegung des namens der Stelle (editierbar)
     */
    private TextFigure stelleNameFigure;
    
    /**
     * NumberTextFigure für die Aktuelle Anzahl der Marken
     */
    private NumberTextFigure aktAnzFigure;
    
    /**
     * NumberTextFigure für die minimale Anzahl der Marken
     */
    private NumberTextFigure minAnzFigure;
    
    /**
     * NumberTextFigure für die maximale Anzahl der Marken
     */
    private NumberTextFigure maxAnzFigure;
    
    /**
     * EllipseFigure für die Stelle
     */
    private EllipseFigure stelleFigure;
    
    private TextFigure labelAktAnzTextFigure;
    
    //????private final int MAXMARKEN = 50;

    //static final long serialVersionUID = 6098176631854387694L;

    /**
     * Create a new instance of StelleFigure with a Rectangle/ EllipseFigure as presentation figure
     */    
    public StelleFigure() {
        //this(new RectangleFigure());
    	//keinen Einfluss this(new EllipseFigure(new Point(100, 100), new Point(2000, 4000)));
    	//this(new EllipseFigure());
    	//this(new RectangleFigure());
    	//CH.ifa.draw.figures.
    	//this(new GraphicalCompositeFigure());  nicht mehr verschiebbare Stellen
    	//this(new GroupFigure()); //geht nicht
    }

    /**
     * Create a new instance of StelleFigure with a given presentation figure
     *
     * @param newPresentationFigure presentation figure
     */    
    public StelleFigure(Figure newPresentationFigure) {
        super(newPresentationFigure);
    }

    /**
     * Hook method called to initizialize a StelleFigure.
     * It is called from the constructors and the clone() method.
     */
    protected void initialize() {
        // start with an empty Composite
        removeAll();

        // set the fonts used to print attributes and methods
        //attributeFont = new Font("Helvetica", Font.PLAIN, 12);
        //methodFont = new Font("Helvetica", Font.PLAIN, 12);

        // create a new Model object associated with this View figure
        setPetriNetSimStelle(new PetriNetSimStelle()); 

        
        
        //***Name***
        // create a TextFigure responsible for the Stelle name
        setStelleNameFigure(new TextFigure() {
            public void setText(String newStelleName) {
                super.setText(newStelleName);
                getPetriNetSimStelle().setNameStelle(newStelleName);
                update();
            }
        });
        getStelleNameFigure().setFont(new Font("Helvetica", Font.BOLD, 12));
        getStelleNameFigure().setText(getPetriNetSimStelle().getNameStelle());
               
        // add the StelleNameFigure TextFigure to the Composite
        GraphicalCompositeFigure nameFigure = new GraphicalCompositeFigure(/*new SeparatorFigure()*/);
        nameFigure.add(stelleNameFigure);
        nameFigure.getLayouter().setInsets(new Insets(10, 10, 10, 10));
        add(nameFigure);
        
        
        
        //***Stelle***
        // erzeuge a EllipseFigure für die darstellung der Stelle
        setStelleFigure(new EllipseFigure(new Point(0,0), new Point(20,20)));
       // stelleFigure.addDependendFigure
        GraphicalCompositeFigure stelleEllipseFigure = new GraphicalCompositeFigure();
        stelleEllipseFigure.add(stelleFigure);
        stelleEllipseFigure.getLayouter().setInsets(new Insets(90, 90, 90, 90));//a.b.c.d (a höhe vertikal der ellipse) (b verschiebung nach rechts) (c Abstand nach unten) (d breite horizontal der ellipse)
        stelleEllipseFigure.moveBy(300, 300);
        
        
        
        //***Aktuelle Anzahl***
        // create a NumberTextFigure für die aktuelle Anzahl Marken
        setAktAnzFigure(new NumberTextFigure() {
            public void setAktAnz(int aktAnzMarken) {
                super.setValue(aktAnzMarken);
                getPetriNetSimStelle().setAktAnz(aktAnzMarken);
                update();
            }
        });
        getAktAnzFigure().setFont(new Font("Helvetica", Font.BOLD, 12));
        getAktAnzFigure().setValue(getPetriNetSimStelle().getAktAnz());
        System.out.println("stelleNameFigure:  x: " + this.stelleNameFigure.center().x + " y: " + this.stelleNameFigure.center().y);
        System.out.println("stelleNameFiguredisplaybox:  x: " + this.stelleNameFigure.displayBox() + " y: " + this.stelleNameFigure.center().y);
        System.out.println("x: " + this.center().x + " y: " + this.center().y);
        System.out.println("stellenamefiguredisplaybox " + this.stelleNameFigure.displayBox().toString());
        System.out.println("this: " + this.displayBox().toString());
        
        System.out.println("Relativ Locator Stelle: " + RelativeLocator.northWest().locate(stelleEllipseFigure));
        System.out.println("Relativ Locator Stelle: " + super.getPresentationFigure().displayBox());
        System.out.println("Relativ Locator Stelle: " + this.getPresentationFigure().displayBox());
               aktAnzFigure.moveBy(super.displayBox().OUT_TOP, super.displayBox().OUT_LEFT); //horizontal, vertikal  durch parameter ersetzen
        
        
        
        // add the aktAnzFigure NumberTextFigure to the Composite
        GraphicalCompositeFigure aktAnzMarkenFigure = new GraphicalCompositeFigure(/*new SeparatorFigure()*/);
        
        labelAktAnzTextFigure = new TextFigure();
        labelAktAnzTextFigure.setText("Aktuelle Anzahl:");
        labelAktAnzTextFigure.moveBy(100, 100);//Hier parameter angeben die relativ zur aktuellen position sind
        //testTextFigure.setReadOnly(true);
        
        //aktAnzMarkenFigure.add(testTextFigure);
        
        //aktAnzMarkenFigure.add(aktAnzFigure);
        //aktAnzMarkenFigure.getLayouter().setInsets(new Insets(10, 10, 10, 0));//a,b,c,d (a Abstand nach oben)(b Abstand zu den Seiten) (c Abstand nach unten) (d Abstand nach rechts)
        //add(aktAnzMarkenFigure);
        //stelleEllipseFigure.add(aktAnzMarkenFigure);
        //add(stelleEllipseFigure);
        //add(stelleFigure);
      
        
        
        //aktAnz Group Figure
        GroupFigure aktAnzGroupFigure = new GroupFigure();
        //aktAnzGroupFigure.add(stelleEllipseFigure);
        aktAnzGroupFigure.add(labelAktAnzTextFigure);
        aktAnzGroupFigure.add(aktAnzFigure);
        aktAnzGroupFigure.add(new EllipseFigure(new Point(10,10), new Point(40,40)));
        add(aktAnzGroupFigure);
        
        
/*        //BSP:///////////////////////////////////////////////////////////////////////////////////////
        TriangleFigure triangle1 = new TriangleFigure(new Point(0,0), new Point(20,20));
        TriangleFigure triangle2 = new TriangleFigure(new Point(20,0), new Point(40,20));

        GroupFigure group = new GroupFigure();

        group.add(triangle1);
        group.add(triangle2);

add(group);
//BSP:///////////////////////////////////////////////////////////////////////////////////////////        
*/        
        //***minimale Anzahl Marken***
        // create a NumberTextFigure für die minimale Anzahl Marken
        setMinAnzFigure(new NumberTextFigure() {
            public void setMinAnz(int minAnzMarken) {
                super.setValue(minAnzMarken);
                getPetriNetSimStelle().setMinAnz(minAnzMarken);
                update();
            }
        });
        getMinAnzFigure().setFont(new Font("Helvetica", Font.BOLD, 12));
        getMinAnzFigure().setValue(getPetriNetSimStelle().getMinAnz());
        
        // add the minAnzFigure NumberTextFigure to the Composite
        GraphicalCompositeFigure minAnzMarkenFigure = new GraphicalCompositeFigure(/*new SeparatorFigure()*/);
        minAnzMarkenFigure.add(minAnzFigure);
        minAnzMarkenFigure.getLayouter().setInsets(new Insets(10, 10, 10, 10));
        add(minAnzMarkenFigure);
        
        //***maximale Anzahl Marken***
        // create a NumberTextFigure für die maximale Anzahl Marken
        setMaxAnzFigure(new NumberTextFigure() {
            public void setMaxAnz(int maxAnzMarken) {
                super.setValue(maxAnzMarken);
                getPetriNetSimStelle().setMaxAnz(maxAnzMarken);
                update();
            }
        });
        getMaxAnzFigure().setFont(new Font("Helvetica", Font.BOLD, 12));
        getMaxAnzFigure().setValue(getPetriNetSimStelle().getMaxAnz());
        
        // add the maxAnzFigure NumberTextFigure to the Composite
        GraphicalCompositeFigure maxAnzMarkenFigure = new GraphicalCompositeFigure(/*new SeparatorFigure()*/);
        maxAnzMarkenFigure.add(maxAnzFigure);
        maxAnzMarkenFigure.getLayouter().setInsets(new Insets(10, 10, 10, 10));
        add(maxAnzMarkenFigure);
        

        // create a figure responsible for maintaining attributes
        //setAttributesFigure(new GraphicalCompositeFigure(new SeparatorFigure()));
        //getAttributesFigure().getLayouter().setInsets(new Insets(4, 4, 4, 0));
        // add the figure to the Composite
        //add(getAttributesFigure());

        // create a figure responsible for maintaining methods
        //setMethodsFigure(new GraphicalCompositeFigure(new SeparatorFigure()));
        //getMethodsFigure().getLayouter().setInsets(new Insets(4, 4, 4, 0));
        // add the figure to the Composite
        //add(getMethodsFigure());

        //setAttribute(Figure.POPUP_MENU, createPopupMenu());

        super.initialize();
    }

    /**
     * Factory method to create a popup menu which allows to add attributes and methods.
     *
     * @return newly created popup menu
     */
    protected JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new AbstractAction("add marke") {
                public void actionPerformed(ActionEvent event) {
                    addMarke("attribute");
                }
            });
        /*popupMenu.add(new AbstractAction("add method") {
                public void actionPerformed(ActionEvent event) {
                    addMethod("method()");
                }
            });*/

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * Set the figure which containes all figures representing attribute names.
     *
     * @param newAttributesFigure container for other figures
     */
    /*protected void setAttributesFigure(GraphicalCompositeFigure newAttributesFigure) {
        myAttributesFigure = newAttributesFigure;
    }*/

    /**
     * Return the figure which containes all figures representing attribute names.
     *
     * @return container for other figures
     */
    /*public GraphicalCompositeFigure getAttributesFigure() {
        return myAttributesFigure;
    }*/

    /**
     * Set the figure which containes all figures representing methods names.
     *
     * @param newMethodsFigure container for other figures
     */
    /*protected void setMethodsFigure(GraphicalCompositeFigure newMethodsFigure) {
        myMethodsFigure = newMethodsFigure;
    }*/

    /**
     * Return the figure which containes all figures representing method names.
     *
     * @return container for other figures
     */
    /*public GraphicalCompositeFigure getMethodsFigure() {
        return myMethodsFigure;
    }*/

    /**
     * Set the class name text figure responsible for handling user input
     *
     * @param newClassNameFigure text figure for the class name
     */
    protected void setStelleNameFigure(TextFigure newStelleNameFigure) {
        stelleNameFigure = newStelleNameFigure;
    }
    
    /**
     * Return the text figure for the class name
     *
     * @return text figure for the class name
     */
    public TextFigure getStelleNameFigure() {
        return stelleNameFigure;
    }

    public NumberTextFigure getAktAnzFigure() {
		return aktAnzFigure;
	}

	public void setAktAnzFigure(NumberTextFigure aktAnzFigure) {
		this.aktAnzFigure = aktAnzFigure;
	}

	public NumberTextFigure getMinAnzFigure() {
		return minAnzFigure;
	}

	public void setMinAnzFigure(NumberTextFigure minAnzFigure) {
		this.minAnzFigure = minAnzFigure;
	}

	public NumberTextFigure getMaxAnzFigure() {
		return maxAnzFigure;
	}

	public void setMaxAnzFigure(NumberTextFigure maxAnzFigure) {
		this.maxAnzFigure = maxAnzFigure;
	}
	
	public EllipseFigure getStelleFigure() {
		return stelleFigure;
	}

	public void setStelleFigure(EllipseFigure stelleFigure) {
		this.stelleFigure = stelleFigure;
	}

	/**
     * Add a name for an attribute. The underlying class in the model is updated as well.
     * to hold the attribute name.
     *
     * @param newAttribute name of the new attribute
     */
    protected void addMarke(String newMarke) {
       /* getPetriNetSimStelle().addAttribute(newAttribute);
        TextFigure classFigureAttribute = new TextFigure() {
            public void setText(String newString) {
                if (!getText().equals(newString)) {
                    getPetriNetSimStelle().renameAttribute(getText(), newString);
                }
                super.setText(newString);
                updateAttributeFigure();
            }
        };
        classFigureAttribute.setText(newAttribute);
        classFigureAttribute.setFont(attributeFont);
        getAttributesFigure().add(classFigureAttribute);
        updateAttributeFigure();*/
    }

    /**
     * Remove an attribute with a given name. The underlying class in the model is updated
     * as well to exclude the attribute name.
     *
     * @param oldAttribute name of the attribute to be removed.
     */
    /*protected void removeAttribute(Figure oldAttribute) {
        getPetriNetSimStelle().removeAttribute(((TextFigure)oldAttribute).getText());
        getAttributesFigure().remove(oldAttribute);
        updateAttributeFigure();
    }*/

    /**
     * Update the attribute figure and the ClassFigure itself as well. This causes calculating
     * the layout of contained figures.
     */
    /*protected void updateAttributeFigure() {
        getAttributesFigure().update();
        update();
    }*/

    /**
     * Add a name for a method. The underlying class in the model is updated as well
     * to hold the method name.
     *
     * @param newMethod name of the new method
     */    
    /*protected void addMethod(String newMethod) {
        getPetriNetSimStelle().addMethod(newMethod);
        TextFigure classFigureMethod = new TextFigure() {
            public void setText(String newString) {
                if (!getText().equals(newString)) {
                    getPetriNetSimStelle().renameMethod(getText(), newString);
                }
                super.setText(newString);
                updateMethodFigure();
            }
        };
        classFigureMethod.setText(newMethod);
        classFigureMethod.setFont(methodFont);
        getMethodsFigure().add(classFigureMethod);
        updateMethodFigure();
    }*/

    /**
     * Remove an method with a given name. The underlying class in the model is updated
     * as well to exclude the method name.
     *
     * @param oldMethod name of the method to be removed.
     */
    /*protected void removeMethod(Figure oldMethod) {
        getPetriNetSimStelle().removeMethod(((TextFigure)oldMethod).getText());
        getMethodsFigure().remove(oldMethod);
        updateMethodFigure();
    }*/

    /**
     * Update the method figure and the ClassFigure itself as well. This causes calculating
     * the layout of contained figures.
     */
    /*protected void updateMethodFigure() {
        getMethodsFigure().update();
        update();
    }*/

    /**
     * Set the class in the model which should be represented by this StelleFigure
     *
     * @param newClass class in the model
     */
    protected void setPetriNetSimStelle(PetriNetSimStelle newStelle) {
        myStelle = newStelle;
    }

    /**
     * Return the class from the model which is represented by this ClassFigure
     *
     * @return class from the model
     */
    public PetriNetSimStelle getPetriNetSimStelle() { 
        return myStelle;
    }
    
    /**
     * Propagate the removeFromDrawing request up to the container.
     * A ClassFigure should not be removed just because one of its childern
     * is removed.
     */
    /*public void figureRequestRemove(FigureChangeEvent e) {
        Figure removeFigure = e.getFigure();
        if (getAttributesFigure().includes(removeFigure)) {
            removeAttribute(removeFigure);
        }
        else if (getMethodsFigure().includes(removeFigure)) {
            removeMethod(removeFigure);
        }
        else {
            // remove itself
            listener().figureRequestRemove(new FigureChangeEvent(this, displayBox()));
        }
    }*/

    /**
     * Return default handles on all four edges for this figure.
     */
    public Vector handles() {
        Vector handles = new Vector();
        handles.addElement(new NullHandle(getPresentationFigure(), RelativeLocator.northWest()));
        handles.addElement(new NullHandle(getPresentationFigure(), RelativeLocator.northEast()));
        handles.addElement(new NullHandle(getPresentationFigure(), RelativeLocator.southWest()));
        handles.addElement(new NullHandle(getPresentationFigure(), RelativeLocator.southEast()));

        return handles;
    }
 
    /**
     * Test whether this figure has child figures.
     *
     * @return true, if there are no child figures, false otherwise
     */
    public boolean isEmpty() {
        return figureCount() == 0;
    }

    /**
     * Read the figure and its contained elements from the StorableOutput and sets
     * the presentation figure and creates the popup menu.
     */
    public void read(StorableInput dr) throws IOException {
        getStelleNameFigure().setText(dr.readString());

        /*int attributesCount = dr.readInt();
        for (int attributeIndex = 0; attributeIndex < attributesCount; attributeIndex++) {
            addAttribute(dr.readString());
        }

        int methodsCount = dr.readInt();
        for (int methodIndex = 0; methodIndex < methodsCount; methodIndex++) {
            addMethod(dr.readString());
        }*/
        setPresentationFigure((Figure)dr.readStorable());
        setAttribute(Figure.POPUP_MENU, createPopupMenu());
        update();
    }
    
    /**
     * Write the figure and its contained elements to the StorableOutput.
     */
    public void write(StorableOutput dw) {
        dw.writeString(getPetriNetSimStelle().getNameStelle());
        //dw.writeInt(getPetriNetSimStelle().getNumberOfAttributes());

        /*Iterator attributeIterator = getPetriNetSimStelle().getAttributes();
        while (attributeIterator.hasNext()) {
            dw.writeString((String)attributeIterator.next());
        }
        dw.writeInt(getPetriNetSimStelle().getNumberOfMethods());

        Iterator methodIterator = getPetriNetSimStelle().getMethods();
        while (methodIterator.hasNext()) {
            dw.writeString((String)methodIterator.next());
        }
        dw.writeStorable(getPresentationFigure());*/
    }

    /**
     * Read the serialized figure and its contained elements from the input stream and
     * creates the popup menu
     */
    private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
        // call superclass' private readObject() indirectly
        s.defaultReadObject();
        
        setAttribute(Figure.POPUP_MENU, createPopupMenu());
    }
}