package Composeur;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import Widget.*;

/**
 * 
 * @author T3836883
 * 
 */
public class composeurConnexion {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			/*
			Display display;
			Shell fenetreConteneur;

			display = new Display();
		    fenetreConteneur = new Shell(display);
		    fenetreConteneur.setSize(250, 250);
		    fenetreConteneur.setText("Test");
		    fenetreConteneur.setLayout(new FormLayout());
		    
		    //Composite de base sur lequel on va definir la fenetre
			//Composite composite = new Composite(fenetreConteneur, SWT.BORDER);
			//composite.setVisible(true);
			//composite.setSize(250, 250);

		    final Label lbl_login = new Label(fenetreConteneur, SWT.LEFT);
		    lbl_login.setText("Login :");
		    FormData fd = new FormData();
		    fd.top = new FormAttachment(10, 10);
		    fd.left = new FormAttachment(0, 10);
		    fd.bottom = new FormAttachment(30, 0);
		    fd.right = new FormAttachment(40, 0);
		    lbl_login.setLayoutData(fd);

		    final Label lbl_mdp = new Label(fenetreConteneur, SWT.LEFT);
		    lbl_mdp.setText("mot de passe :");
		    fd = new FormData();
		    fd.top = new FormAttachment(lbl_login, 5);
		    fd.left = new FormAttachment(0, 10);
		    fd.bottom = new FormAttachment(40, 0);
		    fd.right = new FormAttachment(40, 0);
		    lbl_mdp.setLayoutData(fd);

		    final Text textlog = new Text(fenetreConteneur, SWT.BORDER | SWT.SINGLE);
		    fd = new FormData();
		    fd.top = new FormAttachment(lbl_login, 0, SWT.TOP);
		    fd.left = new FormAttachment(lbl_login, 10);
		    textlog.setLayoutData(fd);

		    final Text textmdp = new Text(fenetreConteneur, SWT.BORDER | SWT.SINGLE);
		    fd = new FormData();
		    fd.top = new FormAttachment(lbl_mdp, 0, SWT.TOP);
		    fd.left = new FormAttachment(lbl_mdp, 10);
		    textmdp.setLayoutData(fd);

		    fenetreConteneur.open();
		    while (!fenetreConteneur.isDisposed()) {
		      if (!display.readAndDispatch())
		    	  display.sleep();
		    }
		    display.dispose();
		  }
		*/
		
		
		Display display = new Display();	
		Shell fenetreConteneur =  new Shell(display);
		fenetreConteneur.setText("Test");

		
		//Composite de base sur lequel on va definir la fenetre
		Composite composite = new Composite(fenetreConteneur, SWT.BORDER);
		//composite.setVisible(true);
		composite.setSize(250, 250);
		
		// Grille permettant l'allignement des libellé et des textbox
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    composite.setLayout(gridLayout);

		
		
		Label lbl_login = new Label(composite,SWT.LEFT);
		lbl_login.setText("Login");
		lbl_login.setSize(200, 10);
		//lbl_login.setBounds(10,30,50,25);
		
		
		Text textlog = new Text(composite, SWT.BORDER);
		textlog.setText("");
		textlog.setSize(200, 100);
		
		Label lbl_mdp = new Label(composite, SWT.LEFT);
		lbl_mdp.setText("mdp");
		lbl_mdp.setSize(0, 40);
		//lbl_mdp.setBounds(10,70,50,25);
		
		
		Text textmdp = new Text(composite, SWT.BORDER);
		textmdp.setText("");
		textmdp.setSize(200, 10);

		//Text textlog = new Text(fenetreConteneur, SWT.BORDER);;
		//textlog.setBounds(100,30,100,25);
		
		//Text textmdp = new Text(fenetreConteneur, SWT.BORDER);
		//textmdp.setBounds(100,70,100,25);
		
		//composite.pack();
		fenetreConteneur.pack();
		fenetreConteneur.open();
		
		while (!fenetreConteneur.isDisposed()) 
		{
			if (!display.readAndDispatch()) 
			display.sleep();
		}

		
		display.dispose();
		lbl_login.dispose();
		
		
	}

}
