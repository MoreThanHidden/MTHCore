# MTH Core
Because who wants to do things more than once.

Repository Info:
repositories {
		ivy {
			name 'mthcore'
			artifactPattern "http://morethanhidden.16mb.com/mods/[module]-[revision].[ext]"
		}
}

dependencies {
compile name: 'mthcore', version: "${config.mc_version}-${config.mthcore_version}", ext: 'jar'
}
