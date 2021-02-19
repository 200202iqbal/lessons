import java.awt.*;
import java.io.*;

import java.net.*;
import javax.sound.midi.*;

import javax.swing.*;

/**
 * MIDI
 * <pre>
 * MIDI���t�𐧌䂵�܂��B
 * </pre>
 */
public class KSoundMidi {

	private Sequencer sequencer;

	/**
	 * �R���X�g���N�^
	 * <pre>
	 * Midi�I�u�W�F�N�g�𐶐����܂��B
	 * </pre>
	 * @param obj �p�X�����߂�I�u�W�F�N�g
	 * @param fileName �t�@�C����
	 * @param flgLoop true�F�J��Ԃ� �^ false�F�J��Ԃ��Ȃ�
	 */
	public KSoundMidi(Object obj, String fileName, boolean flgLoop){

		try{
			if(obj == null){
				obj = this;
			}
			InputStream is = obj.getClass().getResourceAsStream(fileName);
			Sequence s = MidiSystem.getSequence(is);
			this.sequencer = MidiSystem.getSequencer();
			if(flgLoop){
				this.sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			}
			this.sequencer.open();
			this.sequencer.setSequence(s);

		}catch(InvalidMidiDataException ex){
			ex.printStackTrace();
			return;
		}catch(MidiUnavailableException ex){
			ex.printStackTrace();
			return;
		}catch(IOException ex){
			ex.printStackTrace();
			return;
		}

	} // end KSoundMidi

	/**
	 * ���t�X�^�[�g
	 */
	public void start(){
		sequencer.start();
	}

	/**
	 * ���t�X�g�b�v
	 */
	public void stop(){
		sequencer.stop();
	}

	/**
	 * ���t�ʒu������
	 */
	public void init(){
		sequencer.setTickPosition(0l);
	}

	/**
	 * ���t�����ǂ�����Ԃ��܂�
	 * <pre>
	 * start() ���� stop() ���Ăяo�����܂ł̊ԁAtrue ��Ԃ��܂��B
	 * </pre>
	 */
	public boolean isRunning(){
		return sequencer.isRunning();
	}

}
