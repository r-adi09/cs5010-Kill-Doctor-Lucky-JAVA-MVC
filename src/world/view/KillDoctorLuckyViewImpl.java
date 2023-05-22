package world.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.filechooser.FileSystemView;
import world.ReadOnlyWorld;
import world.control.Features;

/**
 * view implementation class for the game.
 */
public class KillDoctorLuckyViewImpl extends JFrame implements KillDoctorLuckyView {
  private static final long serialVersionUID = 1L;
  private final KillDoctorLuckyAddPlayers addPanel;
  private final KillDoctorLuckyWelcomePanel welcomePanel;
  private final KillDoctorLuckyGamePanel gamePanel;
  private final ReadOnlyWorld model;
  private final JPanel cards;
  private final JDialog pickItems;
  private final JDialog attackTarget;
  private final JDialog movePetDialog;
  private final JDialog newGameDialog;
  private final String welcomePage = "welcome page";
  private final String addPage = "add players page";
  private final String gamePage = "game page";
  private JComboBox<String> itemsInRoom;
  private JComboBox<String> itemsInPlayer;
  private JComboBox<String> roomsInWorld;

  private final int boardheight = 800;
  private final int boardwidth = 800;
  private JMenuBar mb;
  private JMenu xy;
  private JMenuItem m1;
  private JMenuItem m2;
  private JMenuItem m3;

  private JScrollBar hbar;
  private JScrollBar vbar;

  /**
   * class which implements Kill doctor view interface.
   * 
   * @param model readonly model object.
   */
  public KillDoctorLuckyViewImpl(ReadOnlyWorld model) {
    if (model == null) {
      throw new IllegalArgumentException("model object cannot be null");
    }
    this.model = model;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addPanel = new KillDoctorLuckyAddPlayers(model);
    welcomePanel = new KillDoctorLuckyWelcomePanel(model);
    gamePanel = new KillDoctorLuckyGamePanel(model);
    this.cards = new JPanel(new CardLayout());
    itemsInRoom = new JComboBox<>();
    itemsInPlayer = new JComboBox<>();
    this.pickItems = new JDialog();
    this.attackTarget = new JDialog();
    this.movePetDialog = new JDialog();
    this.newGameDialog = new JDialog();
    this.hbar = new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
    this.vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
    cards.add(welcomePanel, welcomePage);
    cards.add(addPanel, addPage);
    cards.add(gamePanel, gamePage);
    this.add(cards);
    this.getContentPane().add(hbar, BorderLayout.SOUTH);
    this.getContentPane().add(vbar, BorderLayout.EAST);
    mb = new JMenuBar();
    xy = new JMenu("Menu");
    m1 = new JMenuItem("Play with current world");
    m2 = new JMenuItem("Play with new world");
    m3 = new JMenuItem("Quit Game");

    xy.add(m1);
    xy.add(m2);
    xy.add(m3);

    mb.add(xy);

    this.setJMenuBar(mb);

    setTitle("Kill Doctor Lucky");
    setSize(this.getWidth(), this.getHeight());
    setPreferredSize(new Dimension(boardheight, boardwidth));
    pack();
    setVisible(true);
  }

  @Override
  public void makeWelcomePanelVisible() {
    CardLayout cl = (CardLayout) (cards.getLayout());
    cl.show(cards, this.welcomePage);
  }

  @Override
  public void setFeatures(Features f) {
    if (f == null) {
      throw new IllegalArgumentException("feature object cannot be null");
    }
    setFocusable(true);
    requestFocus();
    this.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent e) {
        f.movePlayer(e.getX() / 20, (e.getY() / 20 - 3));
      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

      }

    });
    this.addKeyListener(new KeyAdapter() {

      public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == '1') {
          f.lookAround();
        }
        if (e.getKeyChar() == '2') {
          if (model.getRoomItems().length == 0) {
            showMessageBox("No Items present in the room");
          } else {
            showPickItemBox();
            f.pickItem(itemsInRoom.getSelectedItem().toString());
          }
        }
        if (e.getKeyChar() == '3') {
          if (model.getPlayerItems().length == 0) {
            f.playerItems();
          } else {
            showAttackTargetBox();
            f.attackTarget(itemsInPlayer.getSelectedItem().toString());
          }
        }
        if (e.getKeyChar() == '4') {
          showMovePetBox();
          f.movePet(roomsInWorld.getSelectedItem().toString());
        }
      }
    });

    m1.addActionListener(l -> f.startNewGame());
    m2.addActionListener(l -> this.startNewMapGame(f));
    m3.addActionListener(l -> f.quitGame());
    newGameDialog.setVisible(false);
    addPanel.setFeatures(f);
    welcomePanel.setFeatures(f);
    gamePanel.setFeatures(f);
  }

  @Override
  public void showMessageBox(String value) {
    if (value == null) {
      throw new IllegalArgumentException("string cannot be null");
    }
    JOptionPane.showMessageDialog(null, value);
    pickItems.setVisible(false);
  }

  /**
   * Message box which displays the result of every turn.
   * 
   * @param value string message.
   */
  public void showTurnMessageBox(String value) {
    if (value == null) {
      throw new IllegalArgumentException("string cannot be null");
    }
    JOptionPane.showMessageDialog(null, value);
    gamePanel.updateClues();
    pickItems.setVisible(false);
    attackTarget.setVisible(false);
    movePetDialog.setVisible(false);
  }

  @Override
  public void showErrorMessageBox(String value) {
    if (value == null) {
      throw new IllegalArgumentException("string cannot be null");
    }
    JOptionPane.showMessageDialog(null, value, "Error", JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void startGame() {
    CardLayout cl = (CardLayout) (cards.getLayout());
    cl.show(cards, this.gamePage);
    gamePanel.updateClues();
  }

  @Override
  public void addPlayers() {
    CardLayout cl = (CardLayout) (cards.getLayout());
    cl.show(cards, this.addPage);
  }

  @Override
  public void showPickItemBox() {
    itemsInRoom = new JComboBox<>(model.getRoomItems());
    itemsInRoom.setEditable(false);
    JOptionPane.showMessageDialog(new JFrame(), itemsInRoom, "Choose an item to pick",
        JOptionPane.INFORMATION_MESSAGE);
  }

  @Override
  public void showAttackTargetBox() {
    itemsInPlayer = new JComboBox<>(model.getPlayerItems());
    itemsInPlayer.setEditable(false);
    JOptionPane.showMessageDialog(new JFrame(), itemsInPlayer, "Pick an item to Attack",
        JOptionPane.INFORMATION_MESSAGE);
  }

  @Override
  public void showMovePetBox() {
    roomsInWorld = new JComboBox<>(model.getRooms());
    roomsInWorld.setEditable(false);
    JOptionPane.showMessageDialog(new JFrame(), roomsInWorld, "Choose a room to move pet",
        JOptionPane.INFORMATION_MESSAGE);
  }

  @Override
  public void quitGame() {
    this.setVisible(false);
    this.dispose();
    System.exit(1);
  }

  @Override
  public void startNewGame() {
    this.setVisible(false);
    this.dispose();
  }

  @Override
  public void startNewMapGame(Features f) {
    if (f == null) {
      throw new IllegalArgumentException("feature cannot be null");
    }
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    int returnValue = jfc.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      File selectedFile = jfc.getSelectedFile();
      f.startNewMapGame(selectedFile.getAbsolutePath());
    }
  }
}
