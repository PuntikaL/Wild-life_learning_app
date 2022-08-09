import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InfoPanel extends JPanel{
	
	JLabel[] name = new JLabel[9];
	JLabel[] text = new JLabel[9];
	private JLabel[] funFact = new JLabel[9];
	JPanel upperPanel = new JPanel();
	
	protected InfoPanel(int picNum, ImageIcon icon){
		JLabel pic = new JLabel(icon);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		
		JFrame Info = new JFrame();
		Info.setTitle("Infomation");
		Info.setSize(400,400);
		Info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Info.setLocationRelativeTo(null);
		Info.setVisible(true);
		Info.add(this);
		
		for(int i=0;i<9;i++) {
			text[i] = new JLabel();
			funFact[i] = new JLabel();
			name[i] = new JLabel("",SwingConstants.CENTER);
		}
		
		name[0].setText("Red Panda");
		funFact[0].setText("<html>They stand up when being provoked or threatened!</html>");
		text[0].setText("<html>The red panda (Ailurus fulgens), also known as the lesser panda,\n"
				+"is a small mammal native to the eastern Himalayas and southwestern China.\n"
				+"It has dense reddish-brown fur with a black belly and legs, white-lined ears,\n"
				+"a mostly white muzzle and a ringed tail. Its head-to-body length is 51–63.5 cm\n"
				+"(20.1–25.0 in) with a 28–48.5 cm (11.0–19.1 in) tail, and it weighs between 3.2\n"
				+"and 15 kg (7.1 and 33.1 lb). It is well adapted to climbing due to its flexible joints\n"
				+"and curved semi-retractile claws.</html>");
		
		name[1].setText("Sea Otter");
		funFact[1].setText("<html>They sleep on their backs!</html>");
		text[1].setText("<html>The sea otter (Enhydra lutris) is a marine mammal native to the coasts of the northern "
				+ "and eastern North Pacific Ocean. Adult sea otters typically weigh between 14 and 45 kg (31 and 99 lb), "
				+ "making them the heaviest members of the weasel family, but among the smallest marine mammals. "
				+ "Unlike most marine mammals, the sea otter's primary form "
				+ "of insulation is an exceptionally thick coat of fur, the densest in the animal kingdom. "
				+ "Although it can walk on land, the sea otter is capable of living exclusively in the ocean.</html>");
		
		name[2].setText("Rabbit");
		funFact[2].setText("<html>Their teeth never stop growing!</html>");
		text[2].setText("<html>Rabbits, also known as bunnies or bunny rabbits, are small mammals in "
				+ "the family Leporidae (which also contains the hares) of the order Lagomorpha (which also contains the pikas). "
				+ "Oryctolagus cuniculus includes the European rabbit species and its descendants, the world's 305 breeds "
				+ "of domestic rabbit. Sylvilagus includes 13 wild rabbit species, among them the seven types of cottontail. "
				+ "The European rabbit, which has been introduced on every continent except Antarctica, is familiar throughout "
				+ "the world as a wild prey animal and as a domesticated form of livestock and pet.</html>");
		
		name[3].setText("Kangaroo");
		funFact[3].setText("<html>They can't walk backwards!</html>");
		text[3].setText("<html>The kangaroo is a marsupial from the family Macropodidae (macropods, meaning \"large foot\"). "
				+ "In common use the term is used to describe the largest species from this family, the red kangaroo, "
				+ "as well as the antilopine kangaroo, eastern grey kangaroo, and western grey kangaroo.[1] Kangaroos are "
				+ "indigenous to Australia and New Guinea. The Australian government estimates that 42.8 million kangaroos "
				+ "lived within the commercial harvest areas of Australia in 2019, down from 53.2 million in 2013.</html>");
		
		name[4].setText("Horse");
		funFact[4].setText("<html>They have a nearly 360 degree field of vision!</html>");
		text[4].setText("<html>The horse (Equus ferus caballus) is a domesticated, odd-toed, hoofed mammal. "
				+ "It belongs to the taxonomic family Equidae and is one of two extant subspecies of Equus ferus. "
				+ "The horse has evolved over the past 45 to 55 million years from a small multi-toed creature, Eohippus, "
				+ "into the large, single-toed animal of today. Humans began domesticating horses around 4000 BC, and "
				+ "their domestication is believed to have been widespread by 3000 BC. Horses in the subspecies caballus "
				+ "are domesticated, although some domesticated populations live in the wild as feral horses. These feral "
				+ "populations are not true wild horses</html>");
		
		name[5].setText("Wolf");
		funFact[5].setText("<html>Their kids are born deaf and blind with bright blue eyes!</html>");
		text[5].setText("<html>The wolf (Canis lupus), also known as the gray wolf or grey wolf, is a large canine "
				+ "native to Eurasia and North America. More than thirty subspecies of Canis lupus have been recognized, "
				+ "and gray wolves, as popularly understood, comprise wild subspecies. The wolf is the largest extant member "
				+ "of the family Canidae. It is also distinguished from other Canis species by its less pointed ears and muzzle, "
				+ "as well as a shorter torso and a longer tail. The wolf is nonetheless related closely enough to smaller "
				+ "Canis species, such as the coyote and the golden jackal, to produce fertile hybrids with them.</html>");
		
		name[6].setText("<html>Chikadee [Black-capped Chickadee Bird]</html>");
		funFact[6].setText("They weigh less than one-half of an ounce!");
		text[6].setText("<html>The black-capped chickadee (Poecile atricapillus) is a small, nonmigratory, North American "
				+ "songbird that lives in deciduous and mixed forests. It is a passerine bird in the tit family, the Paridae. "
				+ "It is the state bird of Massachusetts and Maine in the United States, and the provincial bird of "
				+ "New Brunswick in Canada. It is well known for its ability to lower its body temperature during cold "
				+ "winter nights, its good spatial memory to relocate the caches where it stores food, and its boldness near "
				+ "humans (sometimes feeding from the hand).</html>");
		
		name[7].setText("Beaver");
		funFact[7].setText("<html>Beavers slap their tails on the water to indicate danger!</html>");
		text[7].setText("<html>Beavers are large, semiaquatic rodents in the genus Castor native to the temperate Northern Hemisphere. "
				+ "There are two extant species: the North American beaver (Castor canadensis) and the Eurasian beaver (C. fiber). "
				+ "Beavers are the second-largest living rodents after the capybaras. They have stout bodies with large heads, "
				+ "long chisel-like incisors, brown or gray fur, hand-like front feet, webbed back feet and flat, scaly tails. "
				+ "The Eurasian beaver has a more elongated skull with a more triangular nasal bone opening, lighter fur color and "
				+ "a narrower tail. The animals can be found in a number of freshwater habitats, such as rivers, streams, lakes and ponds."
				+ "</html>");
		
		name[8].setText("Unicorn");
		funFact[8].setText("<html>They are afraid of Labradors!</html>");
		text[8].setText("<html>The unicorn is a legendary creature that has been described since antiquity as a beast with a single large, "
				+ "pointed, spiraling horn projecting from its forehead.\r\n"
				+ "\r\nIn European literature and art, the unicorn has for the last thousand years or so been depicted as a white horse-like "
				+ "or goat-like animal with a long straight horn with spiralling grooves, cloven hooves, and sometimes a goat's beard. "
				+ "In the Middle Ages and Renaissance, it was commonly described as an extremely wild woodland creature, "
				+ "a symbol of purity and grace, which could be captured only by a virgin. In the encyclopedias, its horn was "
				+ "said to have the power to render poisoned water potable and to heal sickness.</html>");
		
		for(int i=0;i<9;i++) {
			name[i].setFont(new Font("Verdana", Font.BOLD, 20));
			funFact[i].setFont(new Font("Verdana", Font.BOLD, 13));
			text[i].setFont(new Font("Verdana", Font.PLAIN, 10));
		}
		
		textPanel.add(text[picNum], BorderLayout.CENTER);
		textPanel.add(funFact[picNum], BorderLayout.NORTH);
		this.setLayout(new BorderLayout());
		this.add(pic, BorderLayout.CENTER);
		this.add(textPanel, BorderLayout.SOUTH);
		this.add(name[picNum], BorderLayout.NORTH);
	}
}
