package world.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import world.ReadOnlyWorld;
import world.control.Features;

/**
 * Welcome panel for the game which consists of the credits, play button and
 * title.
 */
public class KillDoctorLuckyWelcomePanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private JPanel jpTitle;
  private JPanel jpPicture;
  private JPanel jpPlayButton;
  private JPanel jpCredits;
  private JLabel jllabel;
  private JLabel picLabel;
  private JLabel credits;
  private JButton play;

  /**
   * constructor which implements all the fields in the class.
   * 
   * @param model readonly object.
   */
  public KillDoctorLuckyWelcomePanel(ReadOnlyWorld model) {
    if (model == null) {
      throw new IllegalArgumentException("model object cannot be null");
    }
    this.jpTitle = new JPanel();
    this.jpPicture = new JPanel();
    this.jpPlayButton = new JPanel();
    this.jpCredits = new JPanel();
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.jllabel = new JLabel("Welcome to Kill Doctor Lucky Game");
    this.play = new JButton("Play");
    this.credits = new JLabel("Developed by Rajeshwari Adi");
    BufferedImage myPicture;
    try {
      myPicture = ImageIO.read(new File("res/welcome.jpg"));
    } catch (IOException e) {
      throw new IllegalArgumentException("image not found");
    }
    picLabel = new JLabel(new ImageIcon(myPicture));
    jllabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
    credits.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
    jpTitle.add(jllabel);
    jpPicture.add(picLabel);
    jpCredits.add(credits);
    jpPlayButton.add(play);
    this.add(jpTitle);
    this.add(jpPicture);
    this.add(jpPlayButton);
    this.add(jpCredits);
  }

  @Override
  public void paintComponent(Graphics g) {
    if (g == null) {
      throw new IllegalArgumentException("graphic object cannot be null");
    }
    super.paintComponent(g);
    Graphics2D graphicsObj = (Graphics2D) g;
    Border border = new LineBorder(Color.blue, 3, true);
    this.setBorder(border);
    graphicsObj.setColor(Color.white);
    graphicsObj.fillRect(0, 0, getWidth(), getHeight());
    graphicsObj.setColor(Color.blue);
  }

  /**
   * All the actions in the panel which be taken place in setfeatures method.
   * 
   * @param f features object.
   */
  public void setFeatures(Features f) {
    if (f == null) {
      throw new IllegalArgumentException("feature object cannot be null");
    }
    play.addActionListener(l -> f.addPlayers());
  }
}
