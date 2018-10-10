package it.eng.spagobi.tools.license;

import it.eng.spagobi.commons.utilities.StringUtilities;
import it.eng.spagobi.utilities.exceptions.SpagoBIRuntimeException;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import com.license4j.HardwareID;

public class HostInfo implements DataSerializable {

	static private Logger logger = Logger.getLogger(HostInfo.class);

	private int availableProcessors;
	private String hardwareFingerprint;
	private String hardwareId;

	public HostInfo() {
		try {
			availableProcessors = Runtime.getRuntime().availableProcessors();

			hardwareFingerprint = HardwareID.getHardwareIDFromHostName() + HardwareID.getHardwareIDFromVolumeSerialNumber()
					+ Runtime.getRuntime().availableProcessors();

			hardwareId = StringUtilities.sha256(hardwareFingerprint);
		} catch (Exception e) {
			throw new SpagoBIRuntimeException("Error while generating host info", e);
		}
	}

	public int getAvailableProcessors() {
		return availableProcessors;
	}

	public String getHardwareFingerprint() {
		return hardwareFingerprint;
	}

	public String getHardwareId() {
		return hardwareId;
	}

	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeInt(availableProcessors);
		out.writeUTF(hardwareFingerprint);
		out.writeUTF(hardwareId);

	}

	@Override
	public void readData(ObjectDataInput in) throws IOException {
		availableProcessors = in.readInt();
		hardwareFingerprint = in.readUTF();
		hardwareId = in.readUTF();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HostInfo [availableProcessors=");
		builder.append(availableProcessors);
		builder.append(", hardwareFingerprint=");
		builder.append(hardwareFingerprint);
		builder.append(", hardwareId=");
		builder.append(hardwareId);
		builder.append("]");
		return builder.toString();
	}
}
