package bg.keit.model.domain;
// Generated 05-Aug-2016 14:41:57 by Hibernate Tools 4.3.1.Final

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Jobs generated by hbm2java
 */
@Entity
@Table(name = "JOBS")
public class Jobs implements java.io.Serializable {

	@EmbeddedId
	private JobsId id;
	@ManyToOne
	@JoinColumn(name="MACHINE_ID" ,nullable = false)
	private Machines machines;
	@Column(name = "JOB_NAME", nullable = false, length =4000)
	private String jobName;
	@Column(name = "KEY_VECTOR", nullable = false, length =4000)
	private String keyVector;
	@Column(name = "ENCRYPTION_KEY", nullable = false)
	private byte[] encryptionKey;
	@Column(name = "BATCH_NUMBER", length =4000)
	private String batchNumber;
	@Column(name = "MARK_BATCH")
	private Short markBatch;
	@Column(name = "BATCH_FONT")
	private byte[] batchFont;
	@Column(name = "SN_PREFIX", length =4000)
	private String snPrefix;
	@Column(name = "SN_SUFIX", length =4000)
	private String snSufix;
	@Column(name = "SN_LENGTH")
	private Integer snLength;
	@Column(name = "SN_FONT")
	private byte[] snFont;
	@Column(name = "MARK_SN")
	private Short markSn;
	@OneToMany(mappedBy="jobs", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Perforations> perforationses = new HashSet<Perforations>(0);

	public Jobs() {
	}

	public Jobs(JobsId id, Machines machines, String jobName, String keyVector, byte[] encryptionKey) {
		this.id = id;
		this.machines = machines;
		this.jobName = jobName;
		this.keyVector = keyVector;
		this.encryptionKey = encryptionKey;
	}

	public Jobs(JobsId id, Machines machines, String jobName, String keyVector, byte[] encryptionKey,
                String batchNumber, Short markBatch, byte[] batchFont, String snPrefix, String snSufix, Integer snLength,
                byte[] snFont, Short markSn, Set<Perforations> perforationses) {
		this.id = id;
		this.machines = machines;
		this.jobName = jobName;
		this.keyVector = keyVector;
		this.encryptionKey = encryptionKey;
		this.batchNumber = batchNumber;
		this.markBatch = markBatch;
		this.batchFont = batchFont;
		this.snPrefix = snPrefix;
		this.snSufix = snSufix;
		this.snLength = snLength;
		this.snFont = snFont;
		this.markSn = markSn;
		this.perforationses = perforationses;
	}

	public JobsId getId() {
		return this.id;
	}

	public void setId(JobsId id) {
		this.id = id;
	}

	public Machines getMachines() {
		return this.machines;
	}

	public void setMachines(Machines machines) {
		this.machines = machines;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getKeyVector() {
		return this.keyVector;
	}

	public void setKeyVector(String keyVector) {
		this.keyVector = keyVector;
	}

	public byte[] getEncryptionKey() {
		return this.encryptionKey;
	}

	public void setEncryptionKey(byte[] encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Short getMarkBatch() {
		return this.markBatch;
	}

	public void setMarkBatch(Short markBatch) {
		this.markBatch = markBatch;
	}

	public byte[] getBatchFont() {
		return this.batchFont;
	}

	public void setBatchFont(byte[] batchFont) {
		this.batchFont = batchFont;
	}

	public String getSnPrefix() {
		return this.snPrefix;
	}

	public void setSnPrefix(String snPrefix) {
		this.snPrefix = snPrefix;
	}

	public String getSnSufix() {
		return this.snSufix;
	}

	public void setSnSufix(String snSufix) {
		this.snSufix = snSufix;
	}

	public Integer getSnLength() {
		return this.snLength;
	}

	public void setSnLength(Integer snLength) {
		this.snLength = snLength;
	}

	public byte[] getSnFont() {
		return this.snFont;
	}

	public void setSnFont(byte[] snFont) {
		this.snFont = snFont;
	}

	public Short getMarkSn() {
		return this.markSn;
	}

	public void setMarkSn(Short markSn) {
		this.markSn = markSn;
	}

	public Set<Perforations> getPerforationses() {
		return this.perforationses;
	}

	public void setPerforationses(Set<Perforations> perforationses) {
		this.perforationses = perforationses;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Jobs{" +
				"id=" + id +
				", machines=" + machines +
				", jobName='" + jobName + '\'' +
				", keyVector='" + keyVector + '\'' +
				", encryptionKey=" + java.util.Arrays.toString(encryptionKey) +
				", batchNumber='" + batchNumber + '\'' +
				", markBatch=" + markBatch +
				", batchFont=" + java.util.Arrays.toString(batchFont) +
				", snPrefix='" + snPrefix + '\'' +
				", snSufix='" + snSufix + '\'' +
				", snLength=" + snLength +
				", snFont=" + java.util.Arrays.toString(snFont) +
				", markSn=" + markSn +
				", perforationses=" + perforationses +
				'}';
	}
}
