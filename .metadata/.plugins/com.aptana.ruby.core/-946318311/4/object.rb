class Object < BasicObject
  include Kernel

  ARGF = ARGF
  ARGV = []
  ArgumentError = ArgumentError
  Array = Array
  BasicObject = BasicObject
  Bignum = Bignum
  Binding = Binding
  CROSS_COMPILING = nil
  Class = Class
  Comparable = Comparable
  Complex = Complex
  Config = RbConfig
  Data = Data
  Date = Date
  DateTime = DateTime
  Dir = Dir
  ENV = {"XDG_SESSION_PATH"=>"/org/freedesktop/DisplayManager/Session0", "UPSTART_SESSION"=>"unix:abstract=/com/ubuntu/upstart-session/1000/1935", "SESSION_MANAGER"=>"local/minav-Inspiron-N5010:@/tmp/.ICE-unix/2096,unix/minav-Inspiron-N5010:/tmp/.ICE-unix/2096", "GNOME_DESKTOP_SESSION_ID"=>"this-is-deprecated", "IM_CONFIG_PHASE"=>"1", "GDMSESSION"=>"ubuntu", "COMPIZ_CONFIG_PROFILE"=>"ubuntu", "MANDATORY_PATH"=>"/usr/share/gconf/ubuntu.mandatory.path", "PWD"=>"/usr/eclipse", "SESSIONTYPE"=>"gnome-session", "GIO_LAUNCHED_DESKTOP_FILE_PID"=>"2301", "GTK_IM_MODULE"=>"ibus", "XDG_GREETER_DATA_DIR"=>"/var/lib/lightdm-data/minav", "GDK_CORE_DEVICE_EVENTS"=>"1", "XDG_MENU_PREFIX"=>"gnome-", "TEXTDOMAIN"=>"im-config", "SELINUX_INIT"=>"YES", "PATH"=>"/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games", "XDG_CURRENT_DESKTOP"=>"Unity", "XDG_CONFIG_DIRS"=>"/etc/xdg/xdg-ubuntu:/usr/share/upstart/xdg:/etc/xdg", "APTANA_VERSION"=>"3.6.0", "LIBOVERLAY_SCROLLBAR"=>"0", "GDM_LANG"=>"en_US", "XAUTHORITY"=>"/home/minav/.Xauthority", "XDG_SEAT"=>"seat0", "XDG_SESSION_ID"=>"c2", "XDG_SEAT_PATH"=>"/org/freedesktop/DisplayManager/Seat0", "XDG_VTNR"=>"7", "GTK_MODULES"=>"overlay-scrollbar:unity-gtk-module", "GNOME_KEYRING_CONTROL"=>"/run/user/1000/keyring-zgDUQR", "SHLVL"=>"1", "NODE_PATH"=>"/usr/lib/nodejs:/usr/lib/node_modules:/usr/share/javascript", "TEXTDOMAINDIR"=>"/usr/share/locale/", "JOB"=>"dbus", "XDG_DATA_DIRS"=>"/usr/share/ubuntu:/usr/share/gnome:/usr/local/share/:/usr/share/", "QT_QPA_PLATFORMTHEME"=>"appmenu-qt5", "QT_IM_MODULE"=>"ibus", "GIO_LAUNCHED_DESKTOP_FILE"=>"/etc/xdg/autostart/nautilus-autostart.desktop", "LOGNAME"=>"minav", "GPG_AGENT_INFO"=>"/run/user/1000/keyring-zgDUQR/gpg:0:1", "SESSION"=>"ubuntu", "XMODIFIERS"=>"@im=ibus", "SSH_AUTH_SOCK"=>"/run/user/1000/keyring-zgDUQR/ssh", "DBUS_SESSION_BUS_ADDRESS"=>"unix:abstract=/tmp/dbus-KLfTH2PECJ", "SHELL"=>"/bin/bash", "GNOME_KEYRING_PID"=>"1933", "LANGUAGE"=>"en_US", "DESKTOP_SESSION"=>"ubuntu", "INSTANCE"=>"", "DISPLAY"=>":0.0", "CLUTTER_IM_MODULE"=>"xim", "USER"=>"minav", "HOME"=>"/home/minav", "QT4_IM_MODULE"=>"xim", "DEFAULTS_PATH"=>"/usr/share/gconf/ubuntu.default.path", "XDG_RUNTIME_DIR"=>"/run/user/1000", "LANG"=>"en_US.UTF-8", "OXYGEN_DISABLE_INNER_SHADOWS_HACK"=>"1"}
  EOFError = EOFError
  Encoding = Encoding
  EncodingError = EncodingError
  Enumerable = Enumerable
  Enumerator = Enumerator
  Errno = Errno
  Etc = Etc
  Exception = Exception
  FALSE = false
  FalseClass = FalseClass
  Fiber = Fiber
  FiberError = FiberError
  File = File
  FileTest = FileTest
  FileUtils = FileUtils
  Fixnum = Fixnum
  Float = Float
  FloatDomainError = FloatDomainError
  GC = GC
  Gem = Gem
  Hash = Hash
  IO = IO
  IOError = IOError
  IndexError = IndexError
  Integer = Integer
  Interrupt = Interrupt
  Kernel = Kernel
  KeyError = KeyError
  LoadError = LoadError
  LocalJumpError = LocalJumpError
  Marshal = Marshal
  MatchData = MatchData
  Math = Math
  Method = Method
  Module = Module
  Mutex = Mutex
  NIL = nil
  NameError = NameError
  NilClass = NilClass
  NoMemoryError = NoMemoryError
  NoMethodError = NoMethodError
  NotImplementedError = NotImplementedError
  Numeric = Numeric
  OUTPUT_PATH = "/home/minav/workspace/.metadata/.plugins/com.aptana.ruby.core/-946318311/4/"
  Object = Object
  ObjectSpace = ObjectSpace
  Proc = Proc
  Process = Process
  Psych = Psych
  RUBY_COPYRIGHT = "ruby - Copyright (C) 1993-2013 Yukihiro Matsumoto"
  RUBY_DESCRIPTION = "ruby 1.9.3p484 (2013-11-22 revision 43786) [x86_64-linux]"
  RUBY_ENGINE = "ruby"
  RUBY_PATCHLEVEL = 484
  RUBY_PLATFORM = "x86_64-linux"
  RUBY_RELEASE_DATE = "2013-11-22"
  RUBY_REVISION = 43786
  RUBY_VERSION = "1.9.3"
  Random = Random
  Range = Range
  RangeError = RangeError
  Rational = Rational
  RbConfig = RbConfig
  Regexp = Regexp
  RegexpError = RegexpError
  RubyVM = RubyVM
  RuntimeError = RuntimeError
  STDERR = IO.new
  STDIN = IO.new
  STDOUT = IO.new
  ScanError = StringScanner::Error
  ScriptError = ScriptError
  SecurityError = SecurityError
  Signal = Signal
  SignalException = SignalException
  StandardError = StandardError
  StopIteration = StopIteration
  String = String
  StringIO = StringIO
  StringScanner = StringScanner
  Struct = Struct
  Syck = Syck
  Symbol = Symbol
  SyntaxError = SyntaxError
  SystemCallError = SystemCallError
  SystemExit = SystemExit
  SystemStackError = SystemStackError
  TOPLEVEL_BINDING = #<Binding:0x000000006e0fc8>
  TRUE = true
  TSort = TSort
  Thread = Thread
  ThreadError = ThreadError
  ThreadGroup = ThreadGroup
  Time = Time
  TrueClass = TrueClass
  TypeError = TypeError
  URI = URI
  UnboundMethod = UnboundMethod
  YAML = Psych
  ZeroDivisionError = ZeroDivisionError
  Zlib = Zlib

  def self.yaml_tag(arg0)
  end


  def psych_to_yaml(arg0, arg1, *rest)
  end

  def to_yaml(arg0, arg1, *rest)
  end

  def to_yaml_properties
  end


  protected


  private

  def dir_names(arg0)
  end

  def file_name(arg0)
  end

  def get_classes
  end

  def grab_instance_method(arg0, arg1)
  end

  def print_args(arg0)
  end

  def print_instance_method(arg0, arg1)
  end

  def print_method(arg0, arg1, arg2, arg3, arg4, *rest)
  end

  def print_type(arg0)
  end

  def print_value(arg0)
  end

end
