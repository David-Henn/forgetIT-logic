package forgetit.logic.note;

import forgetit.common.Note;
import forgetit.db.DBNote;
import forgetit.db.IDBNote;
import forgetit.logic.interfaces.ILogicInternalNote;

/**
 * 
 * @author David Henn
 * @date 2.3.2011
 * implementation of ILogicInternalNote
 * @see ILogicInternalNote
 */
public class LogicNoteInternal implements ILogicInternalNote{
	
	private IDBNote dbNote;
	
	public LogicNoteInternal(){
		dbNote = new DBNote();
	}

	@Override
	public void addNote(Note note) {
		//TODO add check input
		dbNote.addNote(note);
	}

	@Override
	public void deleteNode(Note note) {
		//TODO check input
		dbNote.deleteNode(note);
		
	}

	@Override
	public void changeNote(Note note) {
		//TODO check input
		dbNote.changeNote(note);
		
	}

}
