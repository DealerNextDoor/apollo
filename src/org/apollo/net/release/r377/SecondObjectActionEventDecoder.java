package org.apollo.net.release.r377;

import org.apollo.game.event.impl.SecondObjectActionEvent;
import org.apollo.game.model.Position;
import org.apollo.net.codec.game.DataTransformation;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.EventDecoder;

/**
 * An {@link EventDecoder} for the {@link SecondObjectActionEvent}.
 * 
 * @author Graham
 */
public final class SecondObjectActionEventDecoder extends EventDecoder<SecondObjectActionEvent> {

	@Override
	public SecondObjectActionEvent decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		int id = (int) reader.getUnsigned(DataType.SHORT);
		int x = (int) reader.getUnsigned(DataType.SHORT);
		int y = (int) reader.getUnsigned(DataType.SHORT, DataTransformation.ADD);
		return new SecondObjectActionEvent(id, new Position(x, y));
	}

}
