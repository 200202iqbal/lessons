import java.awt.*;
import java.io.*;

import java.net.*;
import javax.sound.midi.*;

import javax.swing.*;

/**
 * MIDI
 * <pre>
 * MIDI演奏を制御します。
 * </pre>
 */
public class KSoundMidi {

	private Sequencer sequencer;

	/**
	 * コンストラクタ
	 * <pre>
	 * Midiオブジェクトを生成します。
	 * </pre>
	 * @param obj パスを決めるオブジェクト
	 * @param fileName ファイル名
	 * @param flgLoop true：繰り返す ／ false：繰り返さない
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
	 * 演奏スタート
	 */
	public void start(){
		sequencer.start();
	}

	/**
	 * 演奏ストップ
	 */
	public void stop(){
		sequencer.stop();
	}

	/**
	 * 演奏位置初期化
	 */
	public void init(){
		sequencer.setTickPosition(0l);
	}

	/**
	 * 演奏中かどうかを返します
	 * <pre>
	 * start() から stop() が呼び出されるまでの間、true を返します。
	 * </pre>
	 */
	public boolean isRunning(){
		return sequencer.isRunning();
	}

}
