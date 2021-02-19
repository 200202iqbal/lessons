import java.awt.*;
import java.io.*;

import java.net.*;
import javax.sound.sampled.*;

import javax.swing.*;

/**
 * Wave
 * <pre>
 * Wave���t�𐧌䂵�܂��B
 * </pre>
 */
public class KSoundWave {

	private Clip clip;

	/**
	 * �R���X�g���N�^
	 * <pre>
	 * Wave�I�u�W�F�N�g�𐶐����܂��B
	 * </pre>
	 * @param obj �p�X�����߂�I�u�W�F�N�g
	 * @param fileName �t�@�C����
	 * @param flgLoop true�F�J��Ԃ� �^ false�F�J��Ԃ��Ȃ�
	 */
	public KSoundWave(Object obj, String fileName, boolean flgLoop){

		try{
			if(obj == null){
				obj = this;
			}
			InputStream is = obj.getClass().getResourceAsStream(fileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(is);
			AudioFormat format = sound.getFormat();
			DataLine.Info di = new DataLine.Info(Clip.class, format);
			this.clip = (Clip) AudioSystem.getLine(di);
			clip.open(sound);

		}catch(UnsupportedAudioFileException ex){
			ex.printStackTrace();
			return;
		}catch(IOException ex){
			ex.printStackTrace();
			return;
		}catch(LineUnavailableException ex){
			ex.printStackTrace();
			return;
		}

	} // end KSoundWave

	/**
	 * ���t�X�^�[�g
	 */
	public void start(){
		clip.setFramePosition(0);
		clip.start();
	}

	/**
	 * ���t�X�g�b�v
	 */
	public void stop(){
		clip.stop();
	}

}
