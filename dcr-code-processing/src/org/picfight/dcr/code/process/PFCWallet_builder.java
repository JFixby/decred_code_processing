
package org.picfight.dcr.code.process;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFile;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.util.Utils;
import com.jfixby.scarabei.api.util.path.RelativePath;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class PFCWallet_builder {

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();

		final String goWorkspacePath = "D:\\PICFIGHT";
		final LocalFile goWS = LocalFileSystem.newFile(goWorkspacePath);

		final File dcrd_project = goWS.child("src").child("github.com").child("decred").child("dcrwallet");
		dcrd_project.checkExists();

		final File pfcd_project = goWS.child("src").child("github.com").child("picfight").child("pfcwallet");
		pfcd_project.checkExists();

		clearProject(pfcd_project);
// Sys.exit();

		final List<File> input = listProjectFiles(dcrd_project);
// L.d("input", input);

		final RelativePath inputPrefix = dcrd_project.getAbsoluteFilePath().getRelativePath();
		final RelativePath outputPrefix = pfcd_project.getAbsoluteFilePath().getRelativePath();

		for (final File f : input) {
			final RelativePath inputTail = f.getAbsoluteFilePath().getRelativePath().splitAt(inputPrefix.size());
			final RelativePath modPath = Utils
				.newRelativePath(inputTail.toString().replaceAll("dcr", "pfc").replaceAll("decred", "picfight"));
			final File outputPath = pfcd_project.proceed(modPath);
			L.d(">>>", f);
			L.d("   ", outputPath);
			processFile(f, outputPath);
// f.getAbsoluteFilePath().getRelativePath().splitAt(inputPrefix)
		}

	}

	private static void processFile (final File i, final File o) throws IOException {
		if (i.isFolder()) {
			o.makeFolder();
			return;
		}

		String data = i.readToString();

		data = DecredReplacer.replace(data);

		o.writeString(data);
	}

	private static List<File> listProjectFiles (final File project) throws IOException {
		final List<File> result = Collections.newList();
		final FilesList child = project.listDirectChildren()
			.filter(file -> !file.getName().equals(".git") && !file.getName().equals("vendor"));
		for (int i = 0; i < child.size(); i++) {
			final File file = child.getElementAt(i);
			if (file.isFile()) {
				result.add(file);
			} else if (file.isFolder()) {
				final List<File> subfiles = listProjectFiles(file);
				result.addAll(subfiles);
				result.add(file);
			}
		}

		return result;
	}

	private static void clearProject (final File project) throws IOException {
		final FilesList child = project.listDirectChildren().filter(file -> !file.getName().equals(".git"));
// L.d("child", child);
		child.deleteAll();
	}

}
